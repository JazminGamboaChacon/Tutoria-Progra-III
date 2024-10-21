package com.example.cliente.service;

import com.example.cliente.model.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UsuarioService {

    private final String baseUrl = "http://localhost:8080/api/";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void guardarUsuario(Usuario usuario) throws Exception {
        URL url = new URL(baseUrl + "usuarios");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        //connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            objectMapper.writeValue(os, usuario);
            os.flush();
        }

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_CREATED) {
            throw new Exception("Error al guardar el usuario, código de respuesta: " + responseCode);
        }
    }

    public List<Usuario> obtenerUsuarios() throws Exception {
        URL url = new URL(baseUrl + "usuarios");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Error al obtener los usuarios, código de respuesta: " + responseCode);
        }

        return objectMapper.readValue(response.toString(), new TypeReference<List<Usuario>>() {});
    }

    public void actualizarUsuario(Long id, Usuario usuarioActualizado) throws Exception {
        URL url = new URL(baseUrl + "usuarios/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            objectMapper.writeValue(os, usuarioActualizado);
            os.flush();
        }

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Error al actualizar el usuario, código de respuesta: " + responseCode);
        }
    }

    public void eliminarUsuario(Long id) throws Exception {
        URL url = new URL(baseUrl + "usuarios/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_NO_CONTENT) {
            throw new Exception("Error al eliminar el usuario, código de respuesta: " + responseCode);
        }
    }
}
