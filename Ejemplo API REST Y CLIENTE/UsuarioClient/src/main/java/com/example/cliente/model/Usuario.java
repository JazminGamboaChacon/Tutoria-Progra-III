package com.example.cliente.model;

public class Usuario {

    private Long id;
    private String nombre;
    private String email;
    private boolean activo;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombre, String email, boolean activo, String password) {
        this.nombre = nombre;
        this.email = email;
        this.activo = activo;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
