package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Serializable>{
	List<Venta> findByIDVentaContaining(String idVenta);
	List<Venta	> findByIDProdutoContaining(String idProducto);
}