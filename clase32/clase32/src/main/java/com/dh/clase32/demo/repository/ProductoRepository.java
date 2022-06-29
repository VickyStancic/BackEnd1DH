package com.dh.clase32.demo.repository;

import com.dh.clase32.demo.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
