package com.BuildStitch_monolith.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMemberEmbeddedId {
    Long projectId;
    Long userId;
}
