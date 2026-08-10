package com.BuildStitch_monolith.Entity;

import com.BuildStitch_monolith.Entity.Enum.ProjectMemberRole;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
public class ProjectMember {
    //Todo: need to implement it properly
    @EmbeddedId
    private Long id;

    private ProjectMemberRole role;

    private User invitedBy;
    @CreationTimestamp
    private Instant invitedAt;
}
