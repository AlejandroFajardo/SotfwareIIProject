/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.uptc.sfII.peliculas.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPelicula;
    private String title;
    private String cast;
    private String synopsis;
    private int duration;
    private String language;
    private Date premiereDate;
    private String genre;
    private String contentRate;
    @Column(name = "image_url")
    private String urlCaratula;

    public Pelicula() {
    }

    public Pelicula(String title, String cast, String synopsis, int duration, String language, Date premiereDate, String genre, String contentRate, String urlCaratula) {
        this.title = title;
        this.cast = cast;
        this.synopsis = synopsis;
        this.duration = duration;
        this.language = language;
        this.premiereDate = premiereDate;
        this.genre = genre;
        this.contentRate = contentRate;
        this.urlCaratula = urlCaratula;
    }
    
    public Integer getIdPelicula() {
        return idPelicula;
    }

    public String getGenre() {
        return genre;
    }
    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getContentRate() {
        return contentRate;
    }

    public void setContentRate(String contentRate) {
        this.contentRate = contentRate;
    }

    public String getUrlCaratula() {
        return urlCaratula;
    }

    public void setUrlCaratula(String urlCaratula) {
        this.urlCaratula = urlCaratula;
    }

    
}
