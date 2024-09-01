package com.wiki.wikipet.resolver;

import com.wiki.wikipet.model.Usuario;
import com.wiki.wikipet.repository.UsuarioRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioQueryResolver implements GraphQLQueryResolver {

    private final UsuarioRepository usuarioRepository;

    public UsuarioQueryResolver(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
