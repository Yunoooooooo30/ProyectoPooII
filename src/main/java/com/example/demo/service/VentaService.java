package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Venta;

public interface VentaService {
	List<Venta> listAllVenta();
	Venta addVenta(Venta venta);
    void deleteVenta(int id);
    Venta getVentaById(int id);
    List<Venta> buscarPorFiltro(String tipo, String valor);
}