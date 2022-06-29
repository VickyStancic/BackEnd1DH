package com.dh.clase32.demo.service;

import com.dh.clase32.demo.entities.Producto;
import com.dh.clase32.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository repository;

    public List<Producto> obtenerTodosProductos(){
        return repository.findAll();
    }

    public String guardar(Producto p){
        repository.save(p);
        return "Ok";
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public String actualizar(Producto p, Long id){
        if (repository.findById(id)!=null){
            p.setId(id);
            guardar(p);
        }
        return "Ok";
    }
}
