package com.wiki.wikipet.service;

import com.wiki.wikipet.model.Usuario;
import com.wiki.wikipet.repository.UsuarioRepository;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;

    public UsuarioService(UsuarioRepository usuarioRepository, EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(String nombre, String email) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);

        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);
        try {
            String subject = "¡Bienvenido a WikiPet, " + nombre + "!";
            String mensajeHTML = "<html>"
                    + "<head>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; background-color: #f2f2f2; }"
                    + "h1 { color: #000359; text-align: center; }"
                    + "p { color: #666; }"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h1>" + nombre + "</h1>"
                    + "<p>Gracias por unirte a WikiPet. Estamos emocionados de tenerte con nosotros.</p>"
                    + "<p>Encuentra toda la información que necesitas para el cuidado de tus mascotas.</p>"
                    + "</body>"
                    + "</html>";

            emailService.sendSimpleEmail(email, subject, mensajeHTML);
        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }

        return usuarioGuardado;
    }

    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuarioAEliminar = usuarioRepository.findById(id).orElse(null);

            if (usuarioAEliminar != null) {
                usuarioRepository.deleteById(id);

                try {
                    String subject = "Cuenta eliminada de WikiPet";
                    String mensajeHTML = "<html>"
                            + "<head>"
                            + "<style>"
                            + "body { font-family: Arial, sans-serif; background-color: #f2f2f2; }"
                            + "h1 { color: #B22222; text-align: center; }"
                            + "p { color: #666; }"
                            + "</style>"
                            + "</head>"
                            + "<body>"
                            + "<h1>Cuenta eliminada</h1>"
                            + "<p>Tu cuenta con el nombre de " + usuarioAEliminar.getNombre() + " ha sido eliminada correctamente.</p>"
                            + "<p>Si esto fue un error, por favor contáctanos para restaurarla.</p>"
                            + "</body>"
                            + "</html>";

                    emailService.sendSimpleEmail(usuarioAEliminar.getEmail(), subject, mensajeHTML);
                } catch (MessagingException e) {
                    System.err.println("Error al enviar el correo de eliminación: " + e.getMessage());
                }

                return true;
            }
        }
        return false;
    }
}
