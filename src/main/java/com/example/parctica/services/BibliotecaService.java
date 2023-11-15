package com.example.parctica.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parctica.DTO.BibliotecaDTO;
import com.example.parctica.modelo.Biblioteca;
import com.example.parctica.modelo.Libro;
import com.example.parctica.repositories.BibliotecaRepository;
import com.example.parctica.repositories.LibroRepository;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository trackRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    ModelMapper modelMapper;

    public Biblioteca insertar(BibliotecaDTO track){

        
        Biblioteca newTrack = new Biblioteca();
        newTrack.setNombre(track.getNombre());
        newTrack.setCiudad(track.getCiudad());
        newTrack.setDireccion(track.getDireccion());

        if (track.getTrackListing() != null) {

         List<Libro> tracks = track.getTrackListing().stream()
                .map(trackDTO -> modelMapper.map(trackDTO, Libro.class))
                .collect(Collectors.toList());

        newTrack.setTrackListing(tracks);
        }

        
        return trackRepository.save(newTrack);
    }

    public List<BibliotecaDTO> listar(){

        Iterable<Biblioteca> tracks = trackRepository.findAll();

        List<BibliotecaDTO> trackDTOs = new ArrayList<BibliotecaDTO>();

        for(Biblioteca track: tracks){
            trackDTOs.add(modelMapper.map(track, BibliotecaDTO.class));

        }

        

        return trackDTOs;
    }

    public void eliminar(Biblioteca biblioteca){
        trackRepository.delete(biblioteca);
    }
        
}
    

