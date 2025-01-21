package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ReporteVenta;

public interface ReporteVentaService {
	List<ReporteVenta> listAllReporteVenta();
	ReporteVenta addReporteVenta(ReporteVenta reporteVenta);
	void deleteReporteVenta(int id);
	ReporteVenta getReporteVentaById(int id);
}