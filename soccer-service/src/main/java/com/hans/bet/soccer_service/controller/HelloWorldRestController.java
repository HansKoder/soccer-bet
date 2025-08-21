package com.hans.bet.soccer_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloWorldRestController {

    @GetMapping("/")
    public ResponseEntity<?> greeting () {
        return ResponseEntity.ok().body(Collections.singletonMap("message", "Hello"));
    }

}
