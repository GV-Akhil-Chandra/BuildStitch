package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Auth.LoginRequestDTO;
import com.BuildStitch_monolith.DTO.Auth.LoginResponseDTO;
import com.BuildStitch_monolith.DTO.Auth.SignUpRequestDTO;
import com.BuildStitch_monolith.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public LoginResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        return null;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        return null;
    }
}
