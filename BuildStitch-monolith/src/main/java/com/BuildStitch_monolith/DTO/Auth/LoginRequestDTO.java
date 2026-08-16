package com.BuildStitch_monolith.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(
        @Email @NotBlank String email,
        @Size(min = 4) String password
) {
}
