package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Auth.LoginRequestDTO;
import com.BuildStitch_monolith.DTO.Auth.LoginResponseDTO;
import com.BuildStitch_monolith.DTO.Auth.SignUpRequestDTO;
import com.BuildStitch_monolith.Entity.User;
import com.BuildStitch_monolith.Exception.BadRequestException;
import com.BuildStitch_monolith.Mapper.ProjectMapper;
import com.BuildStitch_monolith.Mapper.UserMapper;
import com.BuildStitch_monolith.Repository.UserRepository;
import com.BuildStitch_monolith.Security.JwtService;
import com.BuildStitch_monolith.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final ProjectMapper projectMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {

        if (userRepository.findByEmail(signUpRequestDTO.email()).isPresent()) {
            throw new BadRequestException("User Already exists");
        }

        String passwordHash = passwordEncoder.encode(signUpRequestDTO.password());
        User user = User.builder()
                .email(signUpRequestDTO.email())
                .name(signUpRequestDTO.name())
                .password(passwordHash)
                .build();

        userRepository.save(user);

        String token = jwtService.generateAccessToken(user);

        return new LoginResponseDTO(token, projectMapper.toUserProfileDTO(user));
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.email(), loginRequestDTO.password())
        );

        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateAccessToken(user);

        return new LoginResponseDTO(token, projectMapper.toUserProfileDTO(user));
    }
}
