package com.proyectos.FinanSmart.servicios;

import com.proyectos.FinanSmart.entidades.Ingreso;
import com.proyectos.FinanSmart.interfaz.IngresoRepository;
import com.proyectos.FinanSmart.entidades.Usuario;
import com.proyectos.FinanSmart.interfaz.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;


//Se inyectan los dos repositorios (IngresoRepository y UsuarioRepository).
//Se busca el usuario en la base de datos con usuarioRepository.findById(usuarioId).
//Se crea el ingreso y se asocia con el usuario.
//Se guarda en la base de datos usando ingresoRepository.save(ingreso).

public class IngresoService {


    private final IngresoRepository ingresoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public IngresoService(IngresoRepository ingresoRepository, UsuarioRepository usuarioRepository) {
        this.ingresoRepository = ingresoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public Ingreso crearIngreso(Long usuarioId, Double monto, String categoria, LocalDateTime fecha_ingreso) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Ingreso ingreso = new Ingreso();
        ingreso.setMonto(monto);
        ingreso.setUsuario(usuario);
        ingreso.setCategoria(categoria);
        ingreso.setFecha_ingreso(fecha_ingreso);

        return ingresoRepository.save(ingreso);
    }
}
