package com.BuildStitch_monolith.DTO.ProjectFile;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifiedAt,
        String type
) {
}
