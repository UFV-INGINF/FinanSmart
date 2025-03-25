package com.proyectos.FinanSmart.servicios;

import com.proyectos.FinanSmart.entidades.MetaAhorro;
import com.proyectos.FinanSmart.entidades.Usuario;
import com.proyectos.FinanSmart.enums.Estado;
import com.proyectos.FinanSmart.interfaz.MetaAhorroRepository;
import com.proyectos.FinanSmart.interfaz.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MetaAhorroService {

    private final MetaAhorroRepository metaAhorroRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private MetaAhorroService(MetaAhorroRepository metaAhorroRepository, UsuarioRepository usuarioRepository){
        this.metaAhorroRepository = metaAhorroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public MetaAhorro crearMeta(Long usuarioId, Double monto_objetivo, Estado estado, LocalDateTime fecha_meta){
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        MetaAhorro metaAhorro = new MetaAhorro();
        metaAhorro.setUsuario(usuario);
        metaAhorro.setEstado(estado);
        metaAhorro.setMonto_objetivo(monto_objetivo);
        metaAhorro.setFecha_limite(fecha_meta);

        return metaAhorroRepository.save(metaAhorro);
    }
}
