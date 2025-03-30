package com.proyectos.FinanSmart.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Data;


@Entity
@Table(name = "ingresos")
@Data //Genera automaticamente getters, setters, tostring(), equals() y hashcode(). (no hace falta escribirlos)
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  la base de datos generará automáticamente el valor del id (autoincremental).

    private int id;
    private Double monto;
    private String categoria;
    private LocalDateTime fecha_ingreso;

    // Relación con Usuario (Muchos ingresos pueden pertenecer a un usuario)
    @ManyToOne
    //"usuario_id" será el nombre de la columna en la tabla ingreso.
    // nullable = false indica que un ingreso no puede existir sin un usuario.
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
