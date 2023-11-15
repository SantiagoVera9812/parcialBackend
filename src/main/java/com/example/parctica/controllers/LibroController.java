package com.example.parctica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parctica.DTO.LibroDTO;
import com.example.parctica.modelo.Libro;
import com.example.parctica.repositories.LibroRepository;
import com.example.parctica.services.LibroService;

@RestController
@RequestMapping("/Libro")
@CrossOrigin(origins = "/http://localhost:4200", allowedHeaders = "*")
public class LibroController {

    @Autowired
    LibroService trackService;

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    ModelMapper modelMapper;

     @PostMapping("/Agregar")
    public Libro insertar(@RequestBody LibroDTO trackDTO){
        Libro insertedTrack = trackService.insertar(trackDTO);

        return modelMapper.map(insertedTrack, Libro.class);
    }

    @GetMapping("/Listar")
     public List<LibroDTO> listar(){
        Iterable<Libro> tracks = libroRepository.findAll();
		List<LibroDTO> trackDTO = new ArrayList<LibroDTO>();
		
		for (Libro Track : tracks) {
			trackDTO.add(modelMapper.map(Track, LibroDTO.class) );
		}
		
        return trackDTO;
        
    };

    
}
