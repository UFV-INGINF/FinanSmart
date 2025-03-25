package com.proyectos.FinanSmart.interfaz;

import com.proyectos.FinanSmart.entidades.Recomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacionRepository extends JpaRepository<Recomendacion, Long> {
}
