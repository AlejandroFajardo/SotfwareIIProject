/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.uptc.sfII.peliculas.services;

import com.edu.uptc.sfII.peliculas.domain.Pelicula;
import com.edu.uptc.sfII.peliculas.repository.PeliculaRepository;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
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
    
    public Optional<Pelicula> getPeliculaPorNombre(Integer id){
        return peliculaRepository.findById(id);
    }
    
    public void insertPelicula(String title, String cast, String synopsis,
    int duration, String language, Date premiereDate, String contentRate, String urlCaratula){
        this.peliculaRepository.save(new Pelicula(title, cast, synopsis, duration, language, premiereDate, contentRate, "/img/car.png"));
    }
    
    //Buscar pelicula por titulo
    public List<Pelicula> searchPeliculaByTitle(String title){
        return peliculaRepository.findByTitleContaining(title);
    }
}
