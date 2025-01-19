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
import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	@Qualifier("categoriaservice")
	private CategoriaService categoriaService;
	
    @GetMapping("/listaCategoria")
    public ModelAndView listAllCategorias() {
        ModelAndView mav = new ModelAndView("listaCategoria");
        List<Categoria> categorias = categoriaService.listAllCategoria();
        if (categorias == null || categorias.isEmpty()) {
            System.out.println("No se encontraron categorias en la base de datos.");
        }
        mav.addObject("categorias", categorias);
        return mav;
    }

    @GetMapping("/buscar")
    @ResponseBody
    public List<Categoria> buscarCategoria(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
        if (tipo.equals("todos")) {
            return categoriaService.listAllCategoria();
        } else {
            return categoriaService.buscarPorFiltro(tipo, valor);
        }
    }
	
    @PostMapping("/guardar")
    @ResponseBody
    public String addCategoria(@RequestBody Categoria categoria) {
        categoriaService.addCategoria(categoria);
        return "Categoria guardada correctamente";
    }
    
    @GetMapping("/editar/{id}")
    @ResponseBody
    public Categoria getCategoria(@PathVariable("id") int id) {
        return categoriaService.getCategoriaById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String deleteCategoria(@PathVariable("id") int id) {
        categoriaService.deleteCategoria(id);
        return "Categoria eliminada correctamente";
    }

    @GetMapping("/nuevo")
    public String nuevaCategoria() {
        return "Categoria/NuevaCategoria";
    }

    @GetMapping("/gestionar")
    public String gestionarCategoria() {
        return "Categoria/GestionCategoria";
    }
}