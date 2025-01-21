package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Venta;
import com.example.demo.repository.VentaRepository;
import com.example.demo.service.VentaService;

@Service("ventaservice")
public class VentaServiceImpl implements VentaService{
	
	@Autowired
	@Qualifier("ventarepository")
	private VentaRepository ventaRepository;

	@Override
	public List<Venta> listAllVenta() {
		return ventaRepository.findAll();
	}

	@Override
	public Venta addVenta(Venta venta) {
		return ventaRepository.save(venta);
	}

	@Override
	public void deleteVenta(int id) {
		ventaRepository.deleteById(id);
	}

	@Override
	public Venta getVentaById(int id) {
		return ventaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Venta> buscarPorFiltro(String tipo, String valor) {
		switch (tipo) {
		case "idVenta":
			return ventaRepository.findByIdVentaContaining(valor);
		case "idProducto":
			return ventaRepository.findByIdProductoContaining(valor);
		default:
			return listAllVenta();
		}	
	}
}