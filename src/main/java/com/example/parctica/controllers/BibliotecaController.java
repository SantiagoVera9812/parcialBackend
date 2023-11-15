package com.example.parctica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parctica.DTO.BibliotecaDTO;
import com.example.parctica.modelo.Biblioteca;
import com.example.parctica.services.BibliotecaService;


@RestController
@RequestMapping("/Biblioteca")
@CrossOrigin(origins = "/http://localhost:4200", allowedHeaders = "*")
public class BibliotecaController {

    @Autowired
    BibliotecaService trackService;

    @GetMapping("/Listar")
    public List<BibliotecaDTO> lista(){
        return trackService.listar();

    }

    @PostMapping("/Agregar")
    public Biblioteca insertar(@RequestBody BibliotecaDTO track){
        return trackService.insertar(track);
        
    }
    
}
