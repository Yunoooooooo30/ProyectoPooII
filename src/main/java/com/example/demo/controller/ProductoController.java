package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;
import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    @Qualifier("productoservice")
    private ProductoService productoService;
    
    @GetMapping("/listaProducto")
    public ModelAndView listAllProductos() {
        ModelAndView mav = new ModelAndView("listaProducto");
        List<Producto> productos = productoService.listAllProducto();
        if (productos == null || productos.isEmpty()) {
            System.out.println("No se encontraron productos en la base de datos.");
        }
        mav.addObject("productos", productos);
        return mav;
    }


    // Buscar productos según filtro
    @GetMapping("/buscar")
    @ResponseBody
    public List<Producto> buscarProducto(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
        if (tipo.equals("todos")) {
            return productoService.listAllProducto();
        } else {
            return productoService.buscarPorFiltro(tipo, valor);
        }
    }

	// Agregar un nuevo producto
	@PostMapping("/guardar")
	@ResponseBody
	public String addProducto(@RequestBody Producto producto) {
		productoService.addProducto(producto);
		return "Producto guardado correctamente";
	}

    // Obtener un producto por su ID (para edición)
    @GetMapping("/editar/{id}")
    @ResponseBody
    public Producto getProducto(@PathVariable("id") int id) {
        return productoService.getProductoById(id);
    }

    // Eliminar un producto
    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String deleteProducto(@PathVariable("id") int id) {
        productoService.deleteProducto(id);
        return "Producto eliminado correctamente";
    }
    
    @GetMapping("/nuevo")
    public String nuevoProducto() {
        return "Producto/NuevoProducto";
    }

    @GetMapping("/gestionar")
    public String gestionarProducto() {
        return "Producto/GestionProducto";
    }
}