package com.proyectos.FinanSmart.interfaz;

import com.proyectos.FinanSmart.entidades.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoRepository  extends JpaRepository<Ingreso, Long> {
}
