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
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioService;

	@GetMapping("/listaUsuario")
	public ModelAndView listAllUsuarios() {
		ModelAndView mav = new ModelAndView("listaUsuario");
		List<Usuario> usuarios = usuarioService.listAllUsuario();
		if (usuarios == null || usuarios.isEmpty()) {
			System.out.println("No se encontraron usuarios en la base de datos.");
		}
		mav.addObject("usuarios", usuarios);
		return mav;
	}

	@GetMapping("/buscar")
	@ResponseBody
	public List<Usuario> buscarUsuario(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return usuarioService.listAllUsuario();
		} else {
			return usuarioService.buscarPorFiltro(tipo, valor);
		}
	}

    @PostMapping("/guardar")
    @ResponseBody
    public String addUsuario(@RequestBody Usuario usuario) {
        usuarioService.addUsuario(usuario);
        return "Usuario guardado correctamente";
    }
    
    @GetMapping("/editar/{id}")
    @ResponseBody
    public Usuario getUsuario(@PathVariable("id") int id) {
        return usuarioService.getUsuarioById(id);
    }

	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteUsuario(@PathVariable("id") int id) {
		usuarioService.deleteUsuario(id);
		return "Usuario eliminado correctamente";
	}
	
	@GetMapping("/nuevo")
    public String nuevoUsuario() {
        return "Usuario/NuevoUsuario";
    }

    @GetMapping("/gestionar")
    public String gestionarUsuario() {
        return "Usuario/GestionUsuario";
    }
}