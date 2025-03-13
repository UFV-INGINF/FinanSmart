package com.proyectos.FinanSmart.interfaz;

import com.fs.FinanSmart.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JPAREPOSITORY: Sirve para gestionar operaciones CRUD (Create, Read, Update, Delete) sobre la entidad Usuario, sin necesidad de implementar la lógica manualmente
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //USUARIO: entidad que manejo, LONG:tipo de dato clave primaria
}
