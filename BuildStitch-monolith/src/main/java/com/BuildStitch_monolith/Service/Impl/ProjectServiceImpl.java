package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Project.ProjectRequest;
import com.BuildStitch_monolith.DTO.Project.ProjectResponse;
import com.BuildStitch_monolith.DTO.Project.ProjectSummaryDTO;
import com.BuildStitch_monolith.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectSummaryDTO> getAllUserProjectsSummary(Long userID) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(Long userId, Long id) {
        return null;
    }

    @Override
    public ProjectResponse createProject(Long userId, ProjectRequest projectRequest) {
        return null;
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
