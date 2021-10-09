package com.edu.uptc.sfII.peliculas.repository;

import com.edu.uptc.sfII.peliculas.domain.Pelicula;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    
    /*@Query("INSERT INTO 'peliculas' ('title', 'cast', 'synopsis', 'duration', 'language', 'premiere_date', 'content_rate', 'image_url') VALUES ('" + pelicula.getTitle()
            + "', '" + pelicula.getCast() + "', '" + pelicula.getSynopsis() + "'," + pelicula.getDuration() + ",'" + pelicula.getLanguage() + "','" + pelicula.getPremiereDate() + "' ,'" + 
            pelicula.getContentRate() + "','" + pelicula.getUrlCaratula() + "')");
    public default <S extends Pelicula> S save(S pelicula) {
        return pelicula;
    }*/
    
   //Buscar peliculas por nombre
    public List<Pelicula> findByTitleContaining(String title);
}
