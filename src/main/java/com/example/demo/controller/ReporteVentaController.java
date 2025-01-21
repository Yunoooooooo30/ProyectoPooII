package com.example.demo.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.ReporteVenta;
import com.example.demo.service.ReporteVentaService;

@Controller
@RequestMapping("/reporteVenta")
public class ReporteVentaController {
	
	@Autowired
	@Qualifier("reporteventaservice")
	private ReporteVentaService reporteVentaService;
	
	@GetMapping("/listaReporteVenta")
    public ModelAndView listAllReporteVenta() {
        ModelAndView mav = new ModelAndView("listaReporteVenta");
        List<ReporteVenta> reportesVentas = reporteVentaService.listAllReporteVenta();
        if (reportesVentas == null || reportesVentas.isEmpty()) {
            System.out.println("No se encontraron reportes ventas en la base de datos.");
        }
        mav.addObject("reportesVentas", reportesVentas);
        return mav;
    }

	@PostMapping("/guardar")
	@ResponseBody
	public String addReporteVenta(@RequestBody ReporteVenta reporteVenta) {
		reporteVenta.setFechaVenta(new Date());
		reporteVentaService.addReporteVenta(reporteVenta);
		return "Reporte venta guardado correctamente";
	}

    @GetMapping("/editar/{id}")
    @ResponseBody
    public ReporteVenta getReporteVenta(@PathVariable("id") int id) {
        return reporteVentaService.getReporteVentaById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String deleteReporteVenta(@PathVariable("id") int id) {
        reporteVentaService.deleteReporteVenta(id);
        return "Reporte venta eliminado correctamente";
    }
    
    @GetMapping("/nuevo")
    public String nuevoReporteVenta() {
        return "ReporteVenta/NuevoReporteVenta";
    }

    @GetMapping("/gestionar")
    public String gestionarReporteVenta() {
        return "ReporteVenta/GestionReporteVenta";
    }
}