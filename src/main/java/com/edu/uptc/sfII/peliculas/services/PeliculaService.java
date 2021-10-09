/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.uptc.sfII.peliculas.services;

import com.edu.uptc.sfII.peliculas.domain.Pelicula;
import com.edu.uptc.sfII.peliculas.repository.PeliculaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {
    
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }
    
    public List<Pelicula> buscarDestacados(){
        return peliculaRepository.findAll();
    }
    
}
