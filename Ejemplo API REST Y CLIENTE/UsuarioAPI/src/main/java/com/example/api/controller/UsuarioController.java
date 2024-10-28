package com.example.api.controller;

import com.example.api.model.Usuario;
import com.example.api.service.EmailService;
import com.example.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerTodos();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);

        String subject = "Activación de tu cuenta en ApiClient";
        try {
            emailService.enviarCorreoActivacion(nuevoUsuario.getEmail(), subject, nuevoUsuario.getId());
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo de activación", e);
        }
        return nuevoUsuario;
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        return usuarioService.actualizarUsuario(id, usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    @PutMapping("/restablecer-contrasena")
    public Usuario restablecerContraseña(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String nuevaPassword = payload.get("nuevaPassword");

        if (email == null || nuevaPassword == null) {
            throw new RuntimeException("El parámetro 'email' o 'nuevaPassword' es obligatorio.");
        }

        return usuarioService.restablecerContraseña(email, nuevaPassword);
    }

    @PutMapping("/activar/{id}")
    public Usuario activarUsuario(@PathVariable Long id) {
        return usuarioService.activarUsuario(id);
    }

    @PostMapping("/enviar-correo-restablecer")
    public String enviarCorreoRestablecer(@RequestParam String email) {
        Optional<Usuario> usuario = usuarioService.obtenerPorEmail(email);
        if (usuario.isEmpty()) {
            throw new RuntimeException("No se encontró un usuario con el email: " + email);
        }

        String subject = "Restablece tu contraseña";
        String body = "Haz clic en el enlace de abajo para restablecer tu contraseña:";

        emailService.enviarCorreoRestablecimiento(email, subject, body);

        return "Correo de restablecimiento enviado a " + email;
    }

}
