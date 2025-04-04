package com.example.demo.sevice.impl;

import com.example.demo.domain.EmpleadoDTO;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.sevice.EmpleadoService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, ModelMapper modelMapper) {
        this.empleadoRepository = empleadoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmpleadoDTO> obtenerTodos() {
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        return listaEmpleados.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO obtenerPorId(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if( empleado.isPresent( )){
            return convertToDto(empleado.get());
        } else {
            throw new NotFoundException(
                    String.format("No se encontro el empleado con el id: %d", id));
        }
    }

    @Override
    public void modificarEmpleado(EmpleadoDTO empleadoDTO) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(empleadoDTO.getId());
        if( empleadoOptional.isPresent( )){
            empleadoRepository.save(modelMapper.map(empleadoDTO, Empleado.class));
        } else {
            throw new NotFoundException(
                    String.format("No se ha podido actualizar el empleado con id: %d", empleadoDTO.getId()));
        }
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public EmpleadoDTO altaEmpleado(EmpleadoDTO empleadoDTO) {
        return modelMapper.map(empleadoRepository.save(modelMapper.map(empleadoDTO, Empleado.class)), EmpleadoDTO.class);
    }


    @Override
    public List<EmpleadoDTO> obtenerEmleadosPorDepartamento(Long departamentoId) {
        List<Empleado> listaEmpleados = empleadoRepository.findByDepartamento_id(departamentoId);

        return listaEmpleados.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO editarEmpleado(Long id, EmpleadoDTO empleadoDTO) {
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(id);

        if (empleadoOpt.isPresent()) {
            Empleado empleado = empleadoOpt.get();
            empleado.setNombre(empleadoDTO.getNombre());
            empleado.setApellido(empleadoDTO.getApellido());
            Empleado empleadoActualizado = empleadoRepository.save(empleado);

            return modelMapper.map(empleadoRepository.save(modelMapper.map(empleadoDTO, Empleado.class)), EmpleadoDTO.class);
        } else {
            throw new NotFoundException("Empleado con ID " + id + " no encontrado.");
        }
    }

    private EmpleadoDTO convertToDto(Empleado empleado) {
        return modelMapper.map(empleado, EmpleadoDTO.class);
    }
}
