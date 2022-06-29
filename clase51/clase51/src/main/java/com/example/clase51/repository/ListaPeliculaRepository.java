package com.example.clase51.repository;

import com.example.clase51.entities.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListaPeliculaRepository implements IRepository<Pelicula> {
    private List<Pelicula> listaPeliculas;

    @Override
    public Pelicula agregar(Pelicula pelicula) {
        listaPeliculas.add(pelicula);
        return pelicula;
    }

    @Override
    public List<Pelicula> buscar() {
        return listaPeliculas;
    }

    @Override
    public void eliminar(Integer id) {
        int i = 0;
        int indexBuscado = 0;
        boolean bandera = false;
        while (i < listaPeliculas.size() && bandera == false) {
            if (listaPeliculas.get(i).getId() == id) {
                //encontramos la pelicula con id ingresada por parametro
                bandera = true;
                indexBuscado = i;
            }
            i++;
        }
        if (bandera)
            //hacemos el remove
            listaPeliculas.remove(indexBuscado);
    }
}
