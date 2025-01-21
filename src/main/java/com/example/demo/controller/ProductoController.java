package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Producto;
import com.example.demo.entity.ProductoTemporal;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;
import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    @Qualifier("productoservice")
    private ProductoService productoService;
    
    @Autowired
    @Qualifier("categoriaservice")
    private CategoriaService categoriaService;
    
    @GetMapping("/listaProducto")
    @ResponseBody
    public List<Producto> listAllProducto() {
        List<Producto> productos = productoService.listAllProducto();
        if (productos == null || productos.isEmpty()) {
            System.out.println("No se encontraron productos en la base de datos.");
        }
        return productos;
    }

    
    /*@GetMapping("/listaProducto")
    public ModelAndView listAllProductos() {
        ModelAndView mav = new ModelAndView("listaProducto");
        List<Producto> productos = productoService.listAllProducto();
        if (productos == null || productos.isEmpty()) {
            System.out.println("No se encontraron productos en la base de datos.");
        }
        mav.addObject("productos", productos);
        return mav;
    }*/

    @GetMapping("/buscar")
    @ResponseBody
    public List<Producto> buscarProducto(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
        if (tipo.equals("todos")) {
            return productoService.listAllProducto();
        } else {
            return productoService.buscarPorFiltro(tipo, valor);
        }
    }

	@PostMapping("/guardar")
	@ResponseBody
	public String addProducto(@RequestBody Producto producto) {
		productoService.addProducto(producto);
		return "Producto guardado correctamente";
	}

    @GetMapping("/editar/{id}")
    @ResponseBody
    public Producto getProducto(@PathVariable("id") int id) {
        return productoService.getProductoById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String deleteProducto(@PathVariable("id") int id) {
        productoService.deleteProducto(id);
        return "Producto eliminado correctamente";
    }
    
    @GetMapping("/nuevo")
    public String nuevoProducto(Model model) {
    	List<Categoria> categorias = categoriaService.listAllCategoria();
        model.addAttribute("categorias", categorias);
        return "Producto/NuevoProducto";
    }

    @GetMapping("/gestionar")
    public String gestionarProducto(Model  model) {
    	List<ProductoTemporal> productosConCategoria = productoService.listAllProductoWithCategoria();
    	List<Categoria> categorias = categoriaService.listAllCategoria();
        // Agregar tanto las categorías como los productos al modelo
        model.addAttribute("productos", productosConCategoria);
        model.addAttribute("categorias", categorias);
        return "Producto/GestionProducto"; 
    }
}