package com.example.demo.sevice.impl;

import com.example.demo.domain.DepartamentoDTO;
import com.example.demo.model.Departamento;
import com.example.demo.repository.DepartamentoRepository;
import com.example.demo.sevice.DepartamentoService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


@Log4j2
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final ModelMapper modelMapper;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository, ModelMapper modelMapper) {
        this.departamentoRepository = departamentoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public DepartamentoDTO altaDepartamento(DepartamentoDTO departamentoDTO) {
        return modelMapper.map(departamentoRepository.save(modelMapper.map(departamentoDTO, Departamento.class)), DepartamentoDTO.class);
    }

    private DepartamentoDTO convertToDto(Departamento departamento) {
        return modelMapper.map(departamento, DepartamentoDTO.class);
    }
}
