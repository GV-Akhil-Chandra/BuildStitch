package com.BuildStitch_monolith.Controller;

import com.BuildStitch_monolith.DTO.Auth.LoginRequestDTO;
import com.BuildStitch_monolith.DTO.Auth.LoginResponseDTO;
import com.BuildStitch_monolith.DTO.Auth.SignUpRequestDTO;
import com.BuildStitch_monolith.DTO.Auth.UserProfileDTO;
import com.BuildStitch_monolith.Security.AuthService;
import com.BuildStitch_monolith.Security.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private AuthService authService;
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<LoginResponseDTO> signUp(SignUpRequestDTO signUpRequestDTO){
         return ResponseEntity.ok(authService.signUp(signUpRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDTO> getUserProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }
}
