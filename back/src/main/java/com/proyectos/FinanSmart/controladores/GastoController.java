package com.proyectos.FinanSmart.controladores;


import com.proyectos.FinanSmart.entidades.Gasto;
import com.proyectos.FinanSmart.servicios.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final GastoService gastoService;

    @Autowired
    public GastoController(GastoService gastoService){
        this.gastoService = gastoService;
    }

    @PostMapping("/agregar")
    public Gasto agregarGasto(@RequestParam Long usuarioId, @RequestParam Double monto, @RequestParam String categoria, @RequestParam LocalDateTime fecha_gasto){
        return gastoService.crearGasto(usuarioId, monto, categoria, fecha_gasto);
    }
}
