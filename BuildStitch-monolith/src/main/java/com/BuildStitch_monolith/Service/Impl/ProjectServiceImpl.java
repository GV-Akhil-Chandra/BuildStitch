package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Project.ProjectRequest;
import com.BuildStitch_monolith.DTO.Project.ProjectResponse;
import com.BuildStitch_monolith.DTO.Project.ProjectSummaryDTO;
import com.BuildStitch_monolith.Entity.Project;
import com.BuildStitch_monolith.Entity.User;
import com.BuildStitch_monolith.Repository.ProjectMapper;
import com.BuildStitch_monolith.Repository.ProjectRepository;
import com.BuildStitch_monolith.Repository.UserRepository;
import com.BuildStitch_monolith.Service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectSummaryDTO> getAllUserProjectsSummary(Long userID) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(Long userId, Long id) {
        return null;
    }

    @Override
    @Transactional
    public ProjectResponse createProject(Long userId, ProjectRequest projectRequest) {
        User owner = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("hehe"));

        Project project = Project.builder()
                .name(projectRequest.name())
                .owner(owner)
                .build();

        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long userId, Long projectId, ProjectRequest projectRequest) {
        return null;
    }

    @Override
    public Object softDeleteProject(Long userId, Long projectId) {
        return null;
    }
}
