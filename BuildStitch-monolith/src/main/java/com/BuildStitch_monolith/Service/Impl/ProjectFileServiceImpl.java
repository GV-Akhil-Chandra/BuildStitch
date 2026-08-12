package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.ProjectFile.FileContentResponse;
import com.BuildStitch_monolith.DTO.ProjectFile.FileNode;
import com.BuildStitch_monolith.Service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectFileServiceImpl implements ProjectFileService {
    @Override
    public List<FileNode> getProjectFilesTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
