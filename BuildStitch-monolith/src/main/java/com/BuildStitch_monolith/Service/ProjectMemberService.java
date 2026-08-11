package com.BuildStitch_monolith.Service;

import com.BuildStitch_monolith.DTO.ProjectMember.InviteMemberRequestDTO;
import com.BuildStitch_monolith.DTO.ProjectMember.MemberResponseDTO;
import com.BuildStitch_monolith.DTO.ProjectMember.ProjectMemberRoleDTO;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponseDTO> getAllProjectMembers(Long projectId, Long userId);

    MemberResponseDTO inviteMember(Long projectId, InviteMemberRequestDTO member, Long userId);

    MemberResponseDTO updateMemberRole(Long projectId, Long memberId, ProjectMemberRoleDTO role, Long userId);

    MemberResponseDTO deleteProjectMember(Long projectId, Long memberId, Long userId);
}
