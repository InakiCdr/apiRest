package com.example.demo.controller;

import com.example.demo.domain.EmpleadoDTO;
import com.example.demo.sevice.EmpleadoService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }


    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> obtenerEmpleados() {
        return new ResponseEntity<>(empleadoService.obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public EmpleadoDTO obtenerEmpleadoPorId(@Parameter(description = "Id del empleado")@PathVariable Long id) {
        return empleadoService.obtenerPorId(id);
    }

    @PostMapping
        public EmpleadoDTO crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {

        return empleadoService.altaEmpleado(empleadoDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@Parameter(description = "Id del empleado") @PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
    }


    @GetMapping("/departamento/{idDepartamento}")
    public List<EmpleadoDTO> obtenerEmpleadosPorDepartamento(@Parameter(description = "Id del departamento") @PathVariable("idDepartamento") Long idDepartamento) {
        return empleadoService.obtenerEmleadosPorDepartamento(idDepartamento);
    }

    @PutMapping("/{id}")
    public EmpleadoDTO editarEmpleado(@Parameter(description = "Id del empleado") @PathVariable Long id, @Parameter(description = "Usuario a actualizar")  @RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.editarEmpleado(id, empleadoDTO);
    }

}


