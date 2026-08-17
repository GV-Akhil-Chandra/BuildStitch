package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Project.ProjectRequest;
import com.BuildStitch_monolith.DTO.Project.ProjectResponse;
import com.BuildStitch_monolith.DTO.Project.ProjectSummaryDTO;
import com.BuildStitch_monolith.Entity.Project;
import com.BuildStitch_monolith.Entity.User;
import com.BuildStitch_monolith.Exception.ResourceNotFoundException;
import com.BuildStitch_monolith.Mapper.ProjectMapper;
import com.BuildStitch_monolith.Repository.ProjectRepository;
import com.BuildStitch_monolith.Repository.UserRepository;
import com.BuildStitch_monolith.Service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectSummaryDTO> getAllUserProjectsSummary(Long userID) {

        List<ProjectSummaryDTO> result = projectRepository.getAllAccessibleByUser(userID)
                .stream()
                .map( e -> projectMapper.toProjectSummaryDTO(e))
                .toList();

        return result;
    }

    @Override
    public ProjectResponse getUserProjectById(Long userId, Long projectId) {
        Project project = projectRepository.findAccessibleProjectByUser(userId, projectId).get();
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @Transactional
    public ProjectResponse createProject(Long userId, ProjectRequest projectRequest) {
        User owner = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Project project = Project.builder()
                .name(projectRequest.name())
                .owner(owner)
                .build();

        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long userId, Long projectId, ProjectRequest projectRequest) {
        Project project = projectRepository.findAccessibleProjectByUser(userId, projectId).get();

        project.setName(projectRequest.name());
        projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public Object softDeleteProject(Long userId, Long projectId) {
        Project project = projectRepository.findAccessibleProjectByUser(userId, projectId).get();

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

        return null;
    }
}
