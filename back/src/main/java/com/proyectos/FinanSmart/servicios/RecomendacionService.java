package com.proyectos.FinanSmart.servicios;

import com.fs.FinanSmart.entidades.Recomendacion;
import com.fs.FinanSmart.entidades.Usuario;
import com.fs.FinanSmart.interfaz.RecomendacionRepository;
import com.fs.FinanSmart.interfaz.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class RecomendacionService {

    private final RecomendacionRepository recomendacionRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public RecomendacionService(RecomendacionRepository recomendacionRepository, UsuarioRepository usuarioRepository){
        this.recomendacionRepository = recomendacionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Recomendacion crearRecomendacion(Long usuarioId, String contenido, String estado, LocalDateTime fecha_creacion){
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Recomendacion recomendacion = new Recomendacion();
        recomendacion.setUsuario(usuario);
        recomendacion.setEstado(estado);
        recomendacion.setContenido(contenido);
        recomendacion.setFecha_creacion(fecha_creacion);

        return recomendacionRepository.save(recomendacion);
    }
}
