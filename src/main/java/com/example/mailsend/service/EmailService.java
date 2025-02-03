package com.example.mailsend.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendVerificationEmail(String toEmail, String token) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String link = "http://localhost:8080/api/auth/verify?token=" + token;

        helper.setTo(toEmail);
        helper.setSubject("Vérification d'email");
        helper.setText("Cliquez sur le lien pour vérifier votre email : " + link, true);

        mailSender.send(message);
    }
}

