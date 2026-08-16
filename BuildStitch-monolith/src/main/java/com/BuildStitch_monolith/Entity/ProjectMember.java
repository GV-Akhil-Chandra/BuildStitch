package com.BuildStitch_monolith.Entity;

import com.BuildStitch_monolith.Entity.Enum.ProjectMemberRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectMember {
    // Composite key
    @EmbeddedId
    private ProjectMemberEmbeddedId id;

    // fetching value from composite key
    @ManyToOne
    @MapsId("projectId")
    private Project project;

    // fetching value from composite key
    @ManyToOne
    @MapsId("userId")
    private User user;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ProjectMemberRole role;

    @CreationTimestamp
    private Instant invitedAt;
}
