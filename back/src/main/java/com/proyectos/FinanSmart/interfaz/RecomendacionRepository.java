package com.proyectos.FinanSmart.interfaz;

import com.fs.FinanSmart.entidades.Recomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacionRepository extends JpaRepository<Recomendacion, Long> {
}
