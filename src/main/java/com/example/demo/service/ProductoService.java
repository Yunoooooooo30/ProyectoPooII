package com.example.demo.service;

import com.example.demo.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listAllProducto();
    Producto addProducto(Producto producto);
    void deleteProducto(int id);
    Producto getProductoById(int id);
    List<Producto> buscarPorFiltro(String tipo, String valor);
}