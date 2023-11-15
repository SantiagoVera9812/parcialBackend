package com.example.parctica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.parctica.modelo.Biblioteca;


@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface BibliotecaRepository extends JpaRepository<Biblioteca,Long> {
    
}
