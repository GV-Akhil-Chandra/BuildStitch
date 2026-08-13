package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Auth.UserProfileDTO;
import com.BuildStitch_monolith.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public UserProfileDTO getUserProfile(Long userId) {
        return null;
    }
}
