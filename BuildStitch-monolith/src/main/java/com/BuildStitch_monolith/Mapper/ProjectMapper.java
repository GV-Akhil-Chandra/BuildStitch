package com.BuildStitch_monolith.Mapper;

import com.BuildStitch_monolith.DTO.Project.ProjectResponse;
import com.BuildStitch_monolith.DTO.Project.ProjectSummaryDTO;
import com.BuildStitch_monolith.Entity.Project;
import com.BuildStitch_monolith.DTO.Auth.UserProfileDTO;
import com.BuildStitch_monolith.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryDTO toProjectSummaryDTO(Project project);

    @Mapping(source = "avatarUrl", target = "avatarUrl")
    UserProfileDTO toUserProfileDTO(User user);
}
