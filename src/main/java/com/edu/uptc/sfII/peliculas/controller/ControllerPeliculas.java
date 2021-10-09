/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.uptc.sfII.peliculas.controller;

import com.edu.uptc.sfII.peliculas.domain.Pelicula;
import com.edu.uptc.sfII.peliculas.services.PeliculaService;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerPeliculas {
    
    private final PeliculaService peliculaService;

    public ControllerPeliculas(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }
    
    @RequestMapping("/")
    public String listadoPeliculas(Model model){
        List<Pelicula> cartelera = peliculaService.buscarDestacados();
        model.addAttribute("peliculas", cartelera);
        return "cartelera";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }


    @RequestMapping("/add-movie")
    public String addMovie(){
        return "add-movie";
    }
    
    @RequestMapping("/insert-movie")
    public String insertMovie( @RequestParam("titulo") String title, @RequestParam("reparto") String cast, @RequestParam("sinopsis") String synopsis,
    @RequestParam("duracion") int duration, @RequestParam("idioma") String language, @RequestParam("fecha") Date premiereDate, @RequestParam("clasificacion") String contentRate, @RequestParam("myFile") String urlCaratula, Model model){
        peliculaService.insertPelicula(title, cast, synopsis, duration, language, premiereDate, contentRate, urlCaratula);
        List<Pelicula> cartelera = peliculaService.buscarDestacados();
        model.addAttribute("peliculas", cartelera);
        return "cartelera";
    }
    
    @RequestMapping("/search_pelicula")
    public String buscarPeliculaByTitle(@RequestParam("q") String peliculaTitle, Model model){
        List<Pelicula> result = peliculaService.searchPeliculaByTitle(peliculaTitle);
        model.addAttribute("peliculas", result);
        return "cartelera";
    }

    @RequestMapping("/eliminar_pelicula")
    public String deleteMovieById(@RequestParam("id") int id, Model model){
        peliculaService.deleteById(id);
        return "cartelera";
    }

}


