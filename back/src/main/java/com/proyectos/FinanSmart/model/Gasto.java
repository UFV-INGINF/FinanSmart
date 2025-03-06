package com.proyectos.FinanSmart.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "gastos")
@Data
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  la base de datos generará automáticamente el valor del id (autoincremental).

    private int id;
    private Double monto;
    private String categoria;
    private LocalDateTime fecha_gasto;

    // Relación con Usuario (Muchos ingresos pueden pertenecer a un usuario)
    @ManyToOne
    //"usuario_id" será el nombre de la columna en la tabla gasto.
    // nullable = false indica que un ingreso no puede existir sin un usuario.
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}