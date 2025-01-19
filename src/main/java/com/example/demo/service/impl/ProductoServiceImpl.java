package com.example.demo.service.impl;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("productoservice")
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    @Qualifier("productorepository")
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto getProductoById(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> buscarPorFiltro(String tipo, String valor) {
        switch (tipo) {
            case "codigo":
                return productoRepository.findByCodigoContaining(valor);
            case "marca":
                return productoRepository.findByMarcaContaining(valor);
            case "nombre":
                return productoRepository.findByNombreContaining(valor);
            default:
                return listAllProducto();
        }
    }
}