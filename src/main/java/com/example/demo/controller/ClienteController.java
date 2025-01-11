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

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	@Qualifier("clienteservice")
	private ClienteService clienteService;
	
	@GetMapping("/lista")
	public ModelAndView listAllClientes() {
		ModelAndView mav = new ModelAndView("lista");
		mav.addObject("clientes", clienteService.listAllCliente());
		return mav;
	}
	
	@PostMapping("/agregar")
    public String addCliente(@ModelAttribute Cliente cliente) {
        clienteService.addCliente(cliente);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteCliente(@PathVariable("id") int id) {
        clienteService.deleteCliente(id);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/editar/{id}")
    public String editCliente(@PathVariable("id") int id, Model model) {
    	Cliente cliente = clienteService.getClienteById(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clienteService.listAllCliente());
        return "lista";
    }
}