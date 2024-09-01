package com.wiki.wikipet.service;

import com.wiki.wikipet.model.Usuario;
import com.wiki.wikipet.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List; // Asegúrate de tener esta importación

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(String nombre, String email) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);
        return usuarioRepository.save(nuevoUsuario);
    }
    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false; // O lanzar una excepción si prefieres
        }
    }
}