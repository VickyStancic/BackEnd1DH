package com.example.clase51.controller;

import com.example.clase51.entities.Pelicula;
import com.example.clase51.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    PeliculaService service;

    @GetMapping
    public ResponseEntity<List<Pelicula>> buscarPeliculas(){
        return ResponseEntity.ok(service.buscarPeliculas());
    }
}
