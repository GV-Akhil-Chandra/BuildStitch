package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.ProjectMember.InviteMemberRequestDTO;
import com.BuildStitch_monolith.DTO.ProjectMember.MemberResponseDTO;
import com.BuildStitch_monolith.DTO.ProjectMember.ProjectMemberRoleDTO;
import com.BuildStitch_monolith.Service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponseDTO> getAllProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponseDTO inviteMember(Long projectId, InviteMemberRequestDTO member, Long userId) {
        return null;
    }

    @Override
    public MemberResponseDTO updateMemberRole(Long projectId, Long memberId, ProjectMemberRoleDTO role, Long userId) {
        return null;
    }

    @Override
    public MemberResponseDTO deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
