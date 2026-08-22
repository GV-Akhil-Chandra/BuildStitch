package com.BuildStitch_monolith.Controller;

import com.BuildStitch_monolith.DTO.Project.ProjectRequest;
import com.BuildStitch_monolith.DTO.Project.ProjectResponse;
import com.BuildStitch_monolith.DTO.Project.ProjectSummaryDTO;
import com.BuildStitch_monolith.Security.JwtService;
import com.BuildStitch_monolith.Service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final JwtService jwtService;

    @GetMapping("/my-projects")
    public ResponseEntity<List<ProjectSummaryDTO>> getMyProjects(){
        Long userID = jwtService.getCurrentUserId();
        return ResponseEntity.ok(projectService.getAllUserProjectsSummary(userID));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
        Long userId = jwtService.getCurrentUserId();
        return ResponseEntity.ok(projectService.getUserProjectById(userId, id));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest projectRequest){
        Long userId = jwtService.getCurrentUserId();
        return new ResponseEntity<>(projectService.createProject(userId, projectRequest),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id,
                                                         @RequestBody @Valid ProjectRequest projectRequest){
        Long userId = jwtService.getCurrentUserId();
        return ResponseEntity.ok(projectService.updateProject(userId, id, projectRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        Long userId = jwtService.getCurrentUserId();
        projectService.softDeleteProject(userId, id);
        return ResponseEntity.noContent().build();
    }
}
