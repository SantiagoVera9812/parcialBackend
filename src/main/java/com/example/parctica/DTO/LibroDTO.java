package com.example.parctica.DTO;

import com.example.parctica.modelo.Biblioteca;

import lombok.Getter;
import lombok.Setter;

public class LibroDTO {

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String autor;

    @Getter @Setter
    private Biblioteca biblioteca;
    
}
