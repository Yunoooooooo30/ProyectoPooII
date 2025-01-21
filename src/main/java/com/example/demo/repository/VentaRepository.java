package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Venta;

@Repository("ventarepository")
public interface VentaRepository extends JpaRepository<Venta, Serializable>{
	@Query("SELECT v FROM Venta v WHERE CAST(v.idVenta AS string) LIKE %:idVenta%")
	List<Venta> findByIdVentaContaining(@Param("idVenta") String idVenta);
	@Query("SELECT v FROM Venta v WHERE CAST(v.idProducto AS string) LIKE %:idProducto%")
    List<Venta> findByIdProductoContaining(String idProducto);
}