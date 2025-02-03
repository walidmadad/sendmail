package com.example.mailsend.controller;

import com.example.mailsend.model.User;
import com.example.mailsend.service.UserService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) throws MessagingException {
        userService.registerUser(user.getEmail(), user.getPassword());
        return ResponseEntity.ok("Email de vérification envoyé !");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam String token) {
        boolean verified = userService.verifyUser(token);
        return verified ? ResponseEntity.ok("Compte vérifié !") : ResponseEntity.badRequest().body("Token invalide");
    }
}