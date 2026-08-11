package com.BuildStitch_monolith.Controller;

import com.BuildStitch_monolith.DTO.ProjectMember.InviteMemberRequestDTO;
import com.BuildStitch_monolith.DTO.ProjectMember.MemberResponseDTO;
import com.BuildStitch_monolith.DTO.ProjectMember.ProjectMemberRoleDTO;
import com.BuildStitch_monolith.Service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> getProjectMembers(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getAllProjectMembers(projectId, userId));
    }

    @PostMapping("/invite")
    public ResponseEntity<MemberResponseDTO> inviteMember(@PathVariable Long projectId,
                                                          @RequestBody InviteMemberRequestDTO member){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectMemberService.inviteMember(projectId, member, userId));
    }

    @PatchMapping("/update-role/{memberId}")
    public ResponseEntity<MemberResponseDTO> updateMemberRole(@PathVariable Long projectId,
                                                              @PathVariable Long memberId,
                                                              @RequestBody ProjectMemberRoleDTO role){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId, role, userId));
    }

    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<MemberResponseDTO> deleteMember(@PathVariable Long projectId,
                                                              @PathVariable Long memberId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId, memberId, userId));
    }
}
