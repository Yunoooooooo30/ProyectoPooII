package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Producto;

public interface ProductoService {
	public abstract List<Producto> listAllProducto();
	Producto addProducto(Producto producto);
    void deleteProducto(int id);
    Producto getProductoById(int id);
}