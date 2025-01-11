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

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioService;
	
	@GetMapping("/lista")
	public ModelAndView listAllUsers() {
		
		ModelAndView mav = new ModelAndView("lista");
		mav.addObject("usuarios", usuarioService.listAllUsuario());
		return mav;
	}
	
	@PostMapping("/agregar")
    public String addUser(@ModelAttribute Usuario usuario) {
        usuarioService.addUsuario(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/editar/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("usuarios", usuarioService.listAllUsuario());
        return "lista";
    }
}