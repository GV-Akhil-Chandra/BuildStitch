package com.BuildStitch_monolith.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequestDTO(
        @NotBlank String name,
        @Email @NotBlank String email,
        @Size(min = 4) String password
) {
}
