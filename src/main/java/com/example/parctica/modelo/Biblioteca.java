package com.example.parctica.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(exclude = "id")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long biblioId;
    
    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String direccion;

    @Getter @Setter
    private String ciudad;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "biblioId")
    @JsonIgnore
    @Getter @Setter
    private List<Libro> trackListing = new ArrayList<>(); 


}
