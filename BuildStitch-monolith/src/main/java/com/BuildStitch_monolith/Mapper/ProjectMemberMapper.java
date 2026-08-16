package com.BuildStitch_monolith.Mapper;

import com.BuildStitch_monolith.DTO.ProjectMember.MemberResponseDTO;
import com.BuildStitch_monolith.Entity.ProjectMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "avatarUrl", source = "user.avatarUrl")
    MemberResponseDTO toMemberResponseDTO(ProjectMember projectMember);
}
