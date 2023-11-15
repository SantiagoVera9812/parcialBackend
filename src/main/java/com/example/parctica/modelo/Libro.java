package com.example.parctica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long libroId;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String autor;

    @ManyToOne()
    @JoinColumn(name = "biblioId")
    @Getter @Setter
    @JsonIgnore
    Biblioteca biblioteca;

    
}
