package com.pitang.desafio.lucasmarques.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/signin")
public class SignInResources {

    @GetMapping
    public String doSignIn() {
        return "Login Realizado";
    }
    
    @PostMapping
    public ResponseEntity<?> sigIn() {
        return ResponseEntity.ok().build();
    }
}
