package com.proyectos.FinanSmart.entidades;


import com.fs.FinanSmart.enums.Estado;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "metas")
@Data
public class MetaAhorro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  la base de datos generará automáticamente el valor del id (autoincremental).

    private Double monto_objetivo;
    @Enumerated(EnumType.STRING) //Indica que se guardará como texto en la BBDD
    private Estado estado;
    private LocalDateTime fecha_limite;

    // Relación con Usuario (Muchos ingresos pueden pertenecer a un usuario)
    @ManyToOne
    //"usuario_id" será el nombre de la columna en la tabla gasto.
    // nullable = false indica que un ingreso no puede existir sin un usuario.
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
