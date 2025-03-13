package com.proyectos.FinanSmart.interfaz;


import com.fs.FinanSmart.entidades.MetaAhorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaAhorroRepository extends JpaRepository<MetaAhorro, Long> {
}
