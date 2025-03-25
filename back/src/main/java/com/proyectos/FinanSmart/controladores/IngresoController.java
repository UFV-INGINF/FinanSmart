package com.proyectos.FinanSmart.controladores;

import java.time.LocalDateTime;

import com.proyectos.FinanSmart.entidades.Ingreso;
import com.proyectos.FinanSmart.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/ingresos")
public class IngresoController {

    private final IngresoService ingresoService;

    @Autowired
    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @PostMapping("/agregar")
    public Ingreso agregarIngreso(@RequestParam Long usuarioId, @RequestParam Double monto, @RequestParam String categoria, @RequestParam LocalDateTime fecha_ingreso) {
        return ingresoService.crearIngreso(usuarioId, monto, categoria, fecha_ingreso);
    }
}
