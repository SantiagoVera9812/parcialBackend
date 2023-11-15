package com.example.parctica.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parctica.DTO.LibroDTO;
import com.example.parctica.modelo.Biblioteca;
import com.example.parctica.modelo.Libro;
import com.example.parctica.repositories.BibliotecaRepository;
import com.example.parctica.repositories.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    ModelMapper modelMapper;

    public Libro insertar(LibroDTO libroDTO){

        Long biblioId = libroDTO.getBiblioteca().getBiblioId();
        

        Optional<Biblioteca> biblioOptional = bibliotecaRepository.findById(biblioId);

        if (biblioOptional.isPresent()) {
        
            Biblioteca biblioteca = biblioOptional.get();
            Libro track = modelMapper.map(libroDTO, Libro.class);
            track.setBiblioteca(biblioteca);
            return libroRepository.save(track);
        } else {
        
            return null;
        }
    }


    
}
