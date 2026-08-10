package com.BuildStitch_monolith.DTO.Auth;

public record LoginRequestDTO(
        String email,
        String password
) {
}
