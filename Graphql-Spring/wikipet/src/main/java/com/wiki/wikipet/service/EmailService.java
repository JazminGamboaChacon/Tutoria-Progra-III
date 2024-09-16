package com.wiki.wikipet.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail, String subject, String body) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        String htmlBody = """
                <html>
                <body style="font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;">
                    <div style="max-width: 600px; margin: 0 auto; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);">
                        <h2 style="color: #333;">¡Hola!</h2>
                        <p style="font-size: 16px; color: #555;">
                            """ + body + """
                        </p>
                        <hr style="border: none; border-top: 1px solid #ddd;">
                        <button style= "background-color: red;"> Boton </button>
                        <p style="font-size: 12px; color: #999;">
                            Este correo fue generado automáticamente. Por favor, no responda a este mensaje.
                        </p>
                    </div>
                </body>
                </html>
                """;

        helper.setText(htmlBody, true);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setFrom("dio3sancho@gmail.com");

        mailSender.send(mimeMessage);
        System.out.println("Correo enviado a " + toEmail);
    }
}
