package com.BuildStitch_monolith.DTO.ProjectMember;

import com.BuildStitch_monolith.Entity.Enum.ProjectMemberRole;

import java.time.Instant;

public record MemberResponseDTO(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectMemberRole role,
        Instant invitedAt
) { }
