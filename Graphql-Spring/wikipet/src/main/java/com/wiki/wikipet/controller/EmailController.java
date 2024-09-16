package com.wiki.wikipet.controller;
import com.wiki.wikipet.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @MutationMapping
    public String sendEmail(@Argument String toEmail, @Argument String subject,@Argument String body) throws MessagingException {
        emailService.sendSimpleEmail(toEmail, subject, body);
        return "Correo enviado exitosamente a " + toEmail;
    }
}
