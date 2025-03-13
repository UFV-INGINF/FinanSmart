package com.proyectos.FinanSmart.entidades;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "recomendaciones")
@Data
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String contenido;
    private String estado;
    private LocalDateTime fecha_creacion;

    // Relación con Usuario (Muchos ingresos pueden pertenecer a un usuario)
    @ManyToOne
    //"usuario_id" será el nombre de la columna en la tabla gasto.
    // nullable = false indica que un ingreso no puede existir sin un usuario.
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}


//          FALTA CONTROLADOR