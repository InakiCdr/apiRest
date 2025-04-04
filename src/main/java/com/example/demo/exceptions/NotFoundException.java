package com.example.demo.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{
    @JsonProperty
    final String mensaje;

    public NotFoundException(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }
}
