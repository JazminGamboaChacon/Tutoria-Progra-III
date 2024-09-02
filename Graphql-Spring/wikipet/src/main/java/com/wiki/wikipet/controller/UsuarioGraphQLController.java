package com.wiki.wikipet.controller;

import com.wiki.wikipet.model.Usuario;
import com.wiki.wikipet.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UsuarioGraphQLController {

    private final UsuarioService usuarioService;

    @QueryMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @MutationMapping
    public Usuario crearUsuario(@Argument String nombre, @Argument String email) {
        return usuarioService.crearUsuario(nombre, email);
    }

    @MutationMapping
    public boolean eliminarUsuario(@Argument Long id) {
        return usuarioService.eliminarUsuario(id);
    }
}