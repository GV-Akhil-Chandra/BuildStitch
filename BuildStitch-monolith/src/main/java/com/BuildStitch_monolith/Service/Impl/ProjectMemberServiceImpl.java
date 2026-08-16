package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.ProjectMember.InviteMemberRequestDTO;
import com.BuildStitch_monolith.DTO.ProjectMember.MemberResponseDTO;
import com.BuildStitch_monolith.DTO.ProjectMember.ProjectMemberRoleDTO;
import com.BuildStitch_monolith.Entity.Project;
import com.BuildStitch_monolith.Entity.ProjectMember;
import com.BuildStitch_monolith.Entity.ProjectMemberEmbeddedId;
import com.BuildStitch_monolith.Entity.User;
import com.BuildStitch_monolith.Mapper.ProjectMemberMapper;
import com.BuildStitch_monolith.Repository.ProjectMemberRepository;
import com.BuildStitch_monolith.Repository.ProjectRepository;
import com.BuildStitch_monolith.Repository.UserRepository;
import com.BuildStitch_monolith.Service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMemberMapper projectMemberMapper;

    @Override
    public List<MemberResponseDTO> getAllProjectMembers(Long projectId, Long userId) {
        Project project = projectRepository.findAccessibleProjectByUser(userId, projectId).get();

        List<ProjectMember> list = projectMemberRepository.findByIdProjectId(projectId);

        return list.stream()
                .map(e -> projectMemberMapper.toMemberResponseDTO(e))
                .toList();
    }

    @Override
    @Transactional
    public MemberResponseDTO inviteMember(Long projectId, InviteMemberRequestDTO member, Long userId) {
        Project project = projectRepository.findAccessibleProjectByUser(userId, projectId).get();

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Insufficient privileges");
        }

        User user = userRepository.findByEmail(member.email()).orElseThrow(() -> new RuntimeException("Not found"));

        if(user.getId().equals(userId)){
            throw new RuntimeException("nop3");
        }

        ProjectMemberEmbeddedId memberId = ProjectMemberEmbeddedId.builder()
                .projectId(projectId)
                .userId(user.getId())
                .build();

        if(projectMemberRepository.existsById(memberId)){
            throw new RuntimeException("Already exists...");
        }

        ProjectMember invitedMember = ProjectMember.builder()
                .id(memberId)
                .project(project)
                .role(member.role())
                .user(user)
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(invitedMember);

        return projectMemberMapper.toMemberResponseDTO(invitedMember);
    }

    @Override
    public MemberResponseDTO updateMemberRole(Long projectId, Long memberId, ProjectMemberRoleDTO role, Long userId) {
        Project project = projectRepository.findAccessibleProjectByUser(userId, projectId).get();

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Insufficient privileges");
        }

        ProjectMemberEmbeddedId projectMemberId = ProjectMemberEmbeddedId.builder()
                .projectId(projectId)
                .userId(memberId )
                .build();

        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).get();
        projectMember.setRole(role.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toMemberResponseDTO(projectMember);
    }

    @Override
    public void deleteProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = projectRepository.findAccessibleProjectByUser(userId, projectId).get();

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Insufficient privileges");
        }

        ProjectMemberEmbeddedId projectMemberId = ProjectMemberEmbeddedId.builder()
                .projectId(projectId)
                .userId(memberId )
                .build();

        if(projectMemberRepository.existsById(projectMemberId)){
             throw new RuntimeException("Already exists...");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }
}
