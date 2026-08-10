package com.BuildStitch_monolith.DTO.Auth;

public record LoginResponseDTO(String token,
                               UserProfileDTO userProfileDTO) {
}
