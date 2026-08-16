package com.BuildStitch_monolith.DTO.ProjectMember;

import com.BuildStitch_monolith.Entity.Enum.ProjectMemberRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequestDTO(
        @Email @NotNull @NotBlank String email,
        @NotNull ProjectMemberRole role
) {
}
