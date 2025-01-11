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

import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	@Qualifier("categoriaservice")
	private CategoriaService categoriaService;
	
	@GetMapping("/lista")
	public ModelAndView listAllCategorias() {
		ModelAndView mav = new ModelAndView("lista");
		mav.addObject("categorias", categoriaService.listAllCategoria());
		return mav;
	}
	
	@PostMapping("/agregar")
    public String addCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.addCategoria(categoria);
        return "redirect:/categoria/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteCategoria(@PathVariable("id") int id) {
        categoriaService.deleteCategoria(id);
        return "redirect:/categoria/lista";
    }

    @GetMapping("/editar/{id}")
    public String editCategoria(@PathVariable("id") int id, Model model) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("categorias", categoriaService.listAllCategoria());
        return "lista";
    }
}