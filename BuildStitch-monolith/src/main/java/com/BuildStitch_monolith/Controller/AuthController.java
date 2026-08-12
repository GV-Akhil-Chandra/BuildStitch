package com.BuildStitch_monolith.Controller;

import com.BuildStitch_monolith.DTO.Auth.LoginRequestDTO;
import com.BuildStitch_monolith.DTO.Auth.LoginResponseDTO;
import com.BuildStitch_monolith.DTO.Auth.SignUpRequestDTO;
import com.BuildStitch_monolith.DTO.Auth.UserProfileDTO;
import com.BuildStitch_monolith.Service.AuthService;
import com.BuildStitch_monolith.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<LoginResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){
         return ResponseEntity.ok(authService.signUp(signUpRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDTO> getUserProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }
}
