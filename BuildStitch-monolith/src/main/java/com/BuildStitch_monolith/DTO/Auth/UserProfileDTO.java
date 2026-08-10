package com.BuildStitch_monolith.DTO.Auth;

public record UserProfileDTO(
        Long id,
        String email,
        String name,
        String avatarUrl
){}
