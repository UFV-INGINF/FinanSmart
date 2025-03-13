package com.proyectos.FinanSmart.interfaz;

import com.fs.FinanSmart.entidades.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoRepository  extends JpaRepository<Ingreso, Long> {
}
