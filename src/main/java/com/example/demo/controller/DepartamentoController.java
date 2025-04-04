package com.example.demo.controller;

import com.example.demo.domain.DepartamentoDTO;
import com.example.demo.domain.EmpleadoDTO;
import com.example.demo.sevice.DepartamentoService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService){
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public DepartamentoDTO crearDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        return departamentoService.altaDepartamento(departamentoDTO);
    }

}
