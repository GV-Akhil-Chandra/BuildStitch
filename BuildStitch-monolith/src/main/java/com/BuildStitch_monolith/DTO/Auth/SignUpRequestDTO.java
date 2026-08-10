package com.BuildStitch_monolith.DTO.Auth;

public record SignUpRequestDTO(
        String name,
        String email,
        String password
) {
}
