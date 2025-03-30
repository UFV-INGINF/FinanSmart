package com.proyectos.FinanSmart.controladores;


import com.proyectos.FinanSmart.entidades.MetaAhorro;
import com.proyectos.FinanSmart.enums.Estado;
import com.proyectos.FinanSmart.servicios.MetaAhorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/metaahorro")
public class MetaAhorroController {

    private final MetaAhorroService metaAhorroService;

    @Autowired
    public MetaAhorroController(MetaAhorroService metaAhorroService){
        this.metaAhorroService = metaAhorroService;
    }

    @PostMapping("/agregar")
    public MetaAhorro agregarMeta(@RequestParam Long usuarioId, @RequestParam Double monto_objetivo, @RequestParam Estado estado, @RequestParam LocalDateTime fecha_limite){
        return metaAhorroService.crearMeta(usuarioId, monto_objetivo, estado, fecha_limite);
    }
}
