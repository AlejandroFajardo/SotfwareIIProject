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
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping("/edit-movie")
    public String editMovie(@RequestParam("id") int id, Model model){
        Optional<Pelicula> cartelera = peliculaService.getPeliculaPorID(id);
        model.addAttribute("peliculaedit", cartelera);
        return "edit-movie";
    }
    
    @RequestMapping("/insert-movie")
    public String insertMovie(@RequestParam("titulo") String title, @RequestParam("reparto") String cast, @RequestParam("sinopsis") String synopsis,
    @RequestParam("duracion") int duration, @RequestParam("idioma") String language, @RequestParam("fecha") Date premiereDate, @RequestParam("genero") String genre, @RequestParam("clasificacion") String contentRate, @RequestParam("myFile") String urlCaratula, Model model){
        peliculaService.insertPelicula(title, cast, synopsis, duration, language, premiereDate, genre, contentRate, urlCaratula);
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
    
    @RequestMapping("/search_pelicula_genero")
    public String buscarPeliculaByGenre(@RequestParam("genero") String genero, Model model){
        List<Pelicula> result = peliculaService.searchPeliculaByGenre(genero);
        model.addAttribute("peliculas", result);
        return "cartelera";
    }

    @RequestMapping("/search_pelicula_categoria")
    public String buscarPeliculaByRate(@RequestParam("categoria") String categoria, Model model){
        List<Pelicula> result = peliculaService.searchPeliculaByRate(categoria);
        model.addAttribute("peliculas", result);
        return "cartelera";
    }
}


