package com.BuildStitch_monolith.Service;

import com.BuildStitch_monolith.DTO.Auth.LoginRequestDTO;
import com.BuildStitch_monolith.DTO.Auth.LoginResponseDTO;
import com.BuildStitch_monolith.DTO.Auth.SignUpRequestDTO;

public interface AuthService {
    LoginResponseDTO signUp(SignUpRequestDTO signUpRequestDTO);

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}