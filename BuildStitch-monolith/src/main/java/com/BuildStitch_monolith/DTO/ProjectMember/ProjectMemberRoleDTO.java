package com.BuildStitch_monolith.DTO.ProjectMember;

import com.BuildStitch_monolith.Entity.Enum.ProjectMemberRole;
import jakarta.validation.constraints.NotNull;

public record ProjectMemberRoleDTO(
        @NotNull ProjectMemberRole role
) {
}
