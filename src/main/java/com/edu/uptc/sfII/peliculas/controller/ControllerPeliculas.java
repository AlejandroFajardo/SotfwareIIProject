/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.uptc.sfII.peliculas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lenovo G40
 */
@Controller
public class ControllerPeliculas {
    
    @RequestMapping("/")
    public String listadoPeliculas(){
        return "prueba";
    }
}
