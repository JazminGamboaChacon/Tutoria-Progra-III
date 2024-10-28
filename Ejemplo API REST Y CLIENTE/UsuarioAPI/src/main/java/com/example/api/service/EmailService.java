package com.example.api.service;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoActivacion(String toEmail, String subject, long id) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            String activationLink = "http://localhost:8080/activation.html?id=" + id;

            String htmlBody = "<html>"
                    + "<head>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }"
                    + "h1 { color: #000359; text-align: center; }"
                    + "p { color: #666; font-size: 16px; }"
                    + ".footer { font-size: 12px; color: #999; margin-top: 20px; text-align: center; }"
                    + ".button { display: inline-block; padding: 10px 20px; font-size: 16px; color: #ffffff; background-color: #4CAF50; text-align: center; text-decoration: none; border-radius: 5px; margin-top: 20px; }"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<div style='max-width: 600px; margin: 0 auto; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);'>"
                    + "<h1>¡Bienvenido a ApiClient!</h1>"
                    + "<p>Gracias por registrarte. Haz clic en el botón de abajo para activar tu cuenta:</p>"
                    + "<a href='" + activationLink + "' class='button'>Activar Usuario</a>"
                    + "<hr style='border: none; border-top: 1px solid #ddd;'>"
                    + "<p class='footer'>Este correo fue generado automáticamente. Por favor, no responda a este mensaje.</p>"
                    + "</div>"
                    + "</body>"
                    + "</html>";

            helper.setText(htmlBody, true);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setFrom("dio3sancho@gmail.com");

            mailSender.send(mimeMessage);
            System.out.println("Correo de activación enviado a " + toEmail);

        } catch (MailException | MessagingException e) {
            throw new RuntimeException("Error al enviar el correo de activación", e);
        }
    }

    public void enviarCorreoRestablecimiento(String toEmail, String subject, String body) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            String resetLink = "http://localhost:8080/reset-password.html?email=" + toEmail;

            String htmlBody = "<html>"
                    + "<head>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }"
                    + "h1 { color: #000359; text-align: center; }"
                    + "p { color: #666; font-size: 16px; }"
                    + ".footer { font-size: 12px; color: #999; margin-top: 20px; text-align: center; }"
                    + ".button { display: inline-block; padding: 10px 20px; font-size: 16px; color: #ffffff; background-color: #FF5733; text-align: center; text-decoration: none; border-radius: 5px; margin-top: 20px; }"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<div style='max-width: 600px; margin: 0 auto; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);'>"
                    + "<h1>Restablecimiento de contraseña</h1>"
                    + "<p>" + body + "</p>"
                    + "<a href='" + resetLink + "' class='button'>Restablecer Contraseña</a>"
                    + "<hr style='border: none; border-top: 1px solid #ddd;'>"
                    + "<p class='footer'>Este correo fue generado automáticamente. Por favor, no responda a este mensaje.</p>"
                    + "</div>"
                    + "</body>"
                    + "</html>";

            helper.setText(htmlBody, true);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setFrom("tu-correo@example.com");

            mailSender.send(mimeMessage);
            System.out.println("Correo de restablecimiento enviado a " + toEmail);

        } catch (MailException | MessagingException e) {
            throw new RuntimeException("Error al enviar el correo de restablecimiento de contraseña", e);
        }
    }

}
