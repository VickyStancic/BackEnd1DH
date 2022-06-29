package com.example.clase51.service;

import com.example.clase51.entities.Pelicula;
import com.example.clase51.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    @Autowired
    IRepository<Pelicula> repository;

    public Pelicula agregarPelicula(Pelicula pelicula){
        return repository.agregar(pelicula);
    }

    public List<Pelicula> buscarPeliculas(){
        return repository.buscar();
    }

    public void eliminarPelicula(Integer id){
        repository.eliminar(id);
    }
}
