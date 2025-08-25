package com.hans.bet.soccer_service.auth.controller;

import com.hans.bet.soccer_service.auth.config.JwtUtil;
import com.hans.bet.soccer_service.auth.controller.dto.LoginRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    ResponseEntity<Void> login (@RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication authentication = authenticationManager.authenticate(credentials);

        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());

        String jwt = new JwtUtil().create(request.username());

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, jwt)
                .build();
    }

}
