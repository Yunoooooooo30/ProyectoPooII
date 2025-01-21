package com.example.demo.repository;

import com.example.demo.entity.Producto;
import com.example.demo.entity.ProductoTemporal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

@Repository("productorepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {
	List<Producto> findByCodigoContaining(String codigo); // Para buscar por código
    List<Producto> findByMarcaContaining(String marca); // Para buscar por marca
    List<Producto> findByNombreContaining(String nombre); // Para buscar por nombre
    @Query("SELECT new com.example.demo.entity.ProductoTemporal(p.id_producto, p.codigo, p.marca, p.nombre, p.cantidad, p.precio, p.descripcion, p.igv, c.descripcion) " +
            "FROM Producto p " +
            "JOIN Categoria c ON p.id_categoria = c.id_categoria")
    List<ProductoTemporal> findAllProductosWithCategoria();    
}