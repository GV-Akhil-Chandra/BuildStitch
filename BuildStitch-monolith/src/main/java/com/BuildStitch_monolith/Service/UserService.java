package com.BuildStitch_monolith.Service;

import com.BuildStitch_monolith.DTO.Auth.UserProfileDTO;

public interface UserService {
    UserProfileDTO getUserProfile(Long userId);
}
