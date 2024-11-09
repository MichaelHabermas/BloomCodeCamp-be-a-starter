package com.hcc.controllers;

import com.hcc.dto.AuthCredentialsRequest;
import com.hcc.entities.User;
import com.hcc.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request) {
        ResponseEntity<String> username = authService.login(request);
        return ResponseEntity.ok(username);
    }

    @GetMapping("/validate")
    ResponseEntity<?> validate(@AuthenticationPrincipal User user, @RequestParam String token) {
        Boolean isValid = authService.validate(user, token);
        return ResponseEntity.ok(isValid);
    }
}
