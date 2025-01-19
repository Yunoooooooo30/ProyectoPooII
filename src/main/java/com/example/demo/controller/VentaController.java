package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.Venta;
import com.example.demo.service.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	@Autowired
	@Qualifier("ventaservice")
	private VentaService ventaService;
	
	@GetMapping("/listaVenta")
	public ModelAndView listAllVentas() {
		ModelAndView mav = new ModelAndView("listaVenta");
		List<Venta> ventas = ventaService.listAllVenta();
        if (ventas == null || ventas.isEmpty()) {
            System.out.println("No se encontraron ventas en la base de datos.");
        }
        mav.addObject("ventas", ventas);
		return mav;
	}
	
	@GetMapping("/buscar")
    @ResponseBody
    public List<Venta> buscarVenta(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
        if (tipo.equals("todos")) {
            return ventaService.listAllVenta();
        } else {
            return ventaService.buscarPorFiltro(tipo, valor);
        }
    }
	
	@PostMapping("/guardar")
    @ResponseBody
    public String addVenta(@RequestBody Venta venta) {
        ventaService.addVenta(venta);
        return "Venta guardada correctamente";
    }
	
	@GetMapping("/editar/{id}")
    @ResponseBody
    public Venta getVenta(@PathVariable("id") int id) {
        return ventaService.getVentaById(id);
    }
	
	@DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String deleteCategoria(@PathVariable("id") int id) {
        ventaService.deleteVenta(id);
        return "Venta eliminada correctamente";
    }
	
	@GetMapping("/nuevo")
    public String nuevaVenta() {
        return "Venta/NuevaVenta";
    }
	
	@GetMapping("/gestionar")
    public String gestionarVenta() {
        return "Venta/GestionVenta";
    }
}