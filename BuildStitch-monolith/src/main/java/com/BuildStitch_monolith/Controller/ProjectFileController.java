package com.BuildStitch_monolith.Controller;

import com.BuildStitch_monolith.DTO.ProjectFile.FileContentResponse;
import com.BuildStitch_monolith.DTO.ProjectFile.FileNode;
import com.BuildStitch_monolith.Service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project/{projectId}/files")
@RequiredArgsConstructor
public class ProjectFileController {
    private final ProjectFileService projectFileService;

    @GetMapping()
    public ResponseEntity<List<FileNode>> getProjectFiles(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectFileService.getProjectFilesTree(projectId, userId));
    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId,
                                                       @PathVariable String path){
        Long userId = 1L;
        return ResponseEntity.ok(projectFileService.getFileContent(projectId, path, userId));
    }
}
