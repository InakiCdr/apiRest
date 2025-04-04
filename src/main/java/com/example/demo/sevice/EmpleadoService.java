package com.example.demo.sevice;

import com.example.demo.domain.EmpleadoDTO;


import java.util.List;

public interface EmpleadoService {


     List<EmpleadoDTO> obtenerTodos();

     EmpleadoDTO obtenerPorId(Long id);

     void modificarEmpleado(EmpleadoDTO empleadoDTO);

     void eliminarEmpleado(Long id);

     EmpleadoDTO altaEmpleado(EmpleadoDTO empleadoDTO);

     EmpleadoDTO editarEmpleado(Long id, EmpleadoDTO empleadoDTO);

     List<EmpleadoDTO> obtenerEmleadosPorDepartamento(Long departamentoId);

}
