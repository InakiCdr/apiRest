package com.example.demo.repository;

import com.example.demo.model.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByDepartamento_id(Long idDepartamento);
}

