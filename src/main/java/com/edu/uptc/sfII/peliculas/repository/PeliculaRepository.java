package com.edu.uptc.sfII.peliculas.repository;

import com.edu.uptc.sfII.peliculas.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, String> {
    
}
