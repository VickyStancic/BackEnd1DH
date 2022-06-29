package com.dh.clase32.demo.controller;

import com.dh.clase32.demo.entities.Producto;
import com.dh.clase32.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> traerProductos(){
        return ResponseEntity.ok(service.obtenerTodosProductos());
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Producto p){
        ResponseEntity<String> respuesta=null;

        if (service.guardar(p)!=null){
            respuesta=ResponseEntity.ok("Se guardo el producto sin problemas");
        }
        else{
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo guardar el producto");
        }
        return respuesta;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@RequestBody Producto p, @PathVariable Long id){
        ResponseEntity<String> respuesta=null;

        if (service.actualizar(p,id)!=null){
            respuesta=ResponseEntity.ok("Se guardo el producto sin problemas");
        }
        else{
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo guardar el producto");
        }
        return respuesta;
    }


}
