package com.example.apprec.Modelos;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    String claveUsuario;

    public Usuario(){

    }

    /*
    public Usuario(String email, String password){
        this.email=email;
        this.password=password;
    }
    */
    public Usuario(String nombre, String apellido, String email,String password, String telefono){
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.password=password;
        this.telefono=telefono;


    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
