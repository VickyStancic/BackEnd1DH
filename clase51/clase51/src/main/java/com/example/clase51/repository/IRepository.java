package com.example.clase51.repository;

import java.util.List;

public interface IRepository<T>{
    T agregar (T t);
    List<T> buscar();
    void eliminar(Integer id);
}
