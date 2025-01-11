package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	@Qualifier("productoservice")
	private ProductoService productoService;
	
	@GetMapping("/lista")
	public ModelAndView listAllProductos() {
		ModelAndView mav = new ModelAndView("lista");
		mav.addObject("productos", productoService.listAllProducto());
		return mav;
	}
	
	@PostMapping("/agregar")
    public String addProducto(@ModelAttribute Producto producto) {
		productoService.addProducto(producto);
        return "redirect:/producto/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteProducto(@PathVariable("id") int id) {
    	productoService.deleteProducto(id);
        return "redirect:/producto/lista";
    }

    @GetMapping("/editar/{id}")
    public String editProducto(@PathVariable("id") int id, Model model) {
    	Producto producto = productoService.getProductoById(id);
        model.addAttribute("producto", producto);
        model.addAttribute("productos", productoService.listAllProducto());
        return "lista";
    }
}