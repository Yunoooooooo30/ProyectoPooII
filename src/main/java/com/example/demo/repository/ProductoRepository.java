package com.example.demo.repository;

import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("productorepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {
	List<Producto> findByCodigoContaining(String codigo); // Para buscar por código
    List<Producto> findByMarcaContaining(String marca); // Para buscar por marca
    List<Producto> findByNombreContaining(String nombre); // Para buscar por nombre
}