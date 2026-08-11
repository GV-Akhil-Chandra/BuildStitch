package com.BuildStitch_monolith.Service;

import com.BuildStitch_monolith.DTO.ProjectFile.FileContentResponse;
import com.BuildStitch_monolith.DTO.ProjectFile.FileNode;

import java.util.List;

public interface ProjectFileService {
    List<FileNode> getProjectFilesTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
