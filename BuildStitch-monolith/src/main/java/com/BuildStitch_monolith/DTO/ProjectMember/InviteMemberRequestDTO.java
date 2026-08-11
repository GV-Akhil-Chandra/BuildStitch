package com.BuildStitch_monolith.DTO.ProjectMember;

import com.BuildStitch_monolith.Entity.Enum.ProjectMemberRole;

public record InviteMemberRequestDTO(
        String email,
        ProjectMemberRole role
) {
}
