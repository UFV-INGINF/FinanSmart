package com.proyectos.FinanSmart.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id //id es el campo clave
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  la base de datos generará automáticamente el valor del id (autoincremental).
    private int id;
    private String cadena;
    private String correo;
    private String password;
    private LocalDateTime fecha;

    public Usuario(int id, String cadena, String correo, String password, LocalDateTime fecha) {
        this.id = id;
        this.cadena = cadena;
        this.correo = correo;
        this.password = password;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}

