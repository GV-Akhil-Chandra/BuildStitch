package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Auth.UserProfileDTO;
import com.BuildStitch_monolith.Exception.ResourceNotFoundException;
import com.BuildStitch_monolith.Repository.UserRepository;
import com.BuildStitch_monolith.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserProfileDTO getUserProfile(Long userId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("Bad Credentials"));
    }
}
