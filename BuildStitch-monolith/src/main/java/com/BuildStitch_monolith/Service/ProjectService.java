package com.BuildStitch_monolith.Service;

import com.BuildStitch_monolith.DTO.Project.ProjectRequest;
import com.BuildStitch_monolith.DTO.Project.ProjectResponse;
import com.BuildStitch_monolith.DTO.Project.ProjectSummaryDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryDTO> getAllUserProjectsSummary(Long userID);

    ProjectResponse getUserProjectById(Long userId, Long id);

    ProjectResponse createProject(Long userId, ProjectRequest projectRequest);

    ProjectResponse updateProject(Long userId, Long projectId, ProjectRequest projectRequest);

    Object softDeleteProject(Long userId, Long projectId);
}
