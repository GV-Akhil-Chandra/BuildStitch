package com.BuildStitch_monolith.DTO.Project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
       @NotBlank String name
) {
}
