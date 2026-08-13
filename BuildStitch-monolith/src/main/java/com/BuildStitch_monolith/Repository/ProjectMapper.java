package com.BuildStitch_monolith.Repository;

import com.BuildStitch_monolith.DTO.Project.ProjectResponse;
import com.BuildStitch_monolith.Entity.Project;
import com.BuildStitch_monolith.DTO.Auth.UserProfileDTO;
import com.BuildStitch_monolith.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);

    @Mapping(source = "avatar_url", target = "avatarUrl")
    UserProfileDTO toUserProfileDTO(User user);
}
