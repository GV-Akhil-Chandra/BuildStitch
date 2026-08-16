package com.BuildStitch_monolith.Repository;

import com.BuildStitch_monolith.Entity.ProjectMember;
import com.BuildStitch_monolith.Entity.ProjectMemberEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberEmbeddedId> {
    // findById->ProjectId: this will go deep into the Composite key
    List<ProjectMember> findByIdProjectId(Long projectId);
}
