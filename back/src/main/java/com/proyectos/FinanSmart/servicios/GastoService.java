package com.proyectos.FinanSmart.servicios;

import java.time.LocalDateTime;

import com.proyectos.FinanSmart.entidades.Gasto;
import com.proyectos.FinanSmart.entidades.Usuario;
import com.proyectos.FinanSmart.interfaz.GastoRepository;
import com.proyectos.FinanSmart.interfaz.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class GastoService {

    private final GastoRepository gastoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public GastoService(GastoRepository gastoRepository, UsuarioRepository usuarioRepository){
        this.gastoRepository = gastoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Gasto crearGasto (Long usuarioId, Double monto, String categoria, LocalDateTime fecha_gasto){
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Gasto gasto = new Gasto();
        gasto.setMonto(monto);
        gasto.setUsuario(usuario);
        gasto.setCategoria(categoria);
        gasto.setFecha_gasto(fecha_gasto);

        return gastoRepository.save(gasto);
    }
}
