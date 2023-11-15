package com.example.parctica.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class BibliotecaDTO {

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String direccion;
    
    @Getter @Setter
    private String ciudad;

    @Getter @Setter
    private List<LibroDTO> trackListing;

    
}
