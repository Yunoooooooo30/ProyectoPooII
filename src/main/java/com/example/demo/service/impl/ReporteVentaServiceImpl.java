package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ReporteVenta;
import com.example.demo.repository.ReporteVentaRepository;
import com.example.demo.service.ReporteVentaService;

@Service("reporteventaservice")
public class ReporteVentaServiceImpl implements ReporteVentaService{
	@Autowired
	@Qualifier("reporteventarepository")
	private ReporteVentaRepository reporteVentaRepository;
	
	@Override
	public List<ReporteVenta> listAllReporteVenta() {
		return reporteVentaRepository.findAll();
	}

	@Override
	public ReporteVenta addReporteVenta(ReporteVenta reporteVenta) {
		return reporteVentaRepository.save(reporteVenta);
	}

	@Override
	public void deleteReporteVenta(int id) {
		reporteVentaRepository.deleteById(id);
	}

	@Override
	public ReporteVenta getReporteVentaById(int id) {
		return reporteVentaRepository.findById(id).orElse(null);
	}
}