package com.proyectos.FinanSmart.interfaz;


import com.proyectos.FinanSmart.entidades.MetaAhorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaAhorroRepository extends JpaRepository<MetaAhorro, Long> {
}
