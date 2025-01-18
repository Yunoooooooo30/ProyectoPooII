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

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	@Qualifier("clienteservice")
	private ClienteService clienteService;
	
	@GetMapping("/listaCliente")
    public ModelAndView listAllClientes() {
        ModelAndView mav = new ModelAndView("listaCliente");
        List<Cliente> clientes = clienteService.listAllCliente();
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("No se encontraron clientes en la base de datos.");
        }
        mav.addObject("clientes", clientes);
        return mav;
    }

    @GetMapping("/buscar")
    @ResponseBody
    public List<Cliente> buscarCliente(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
        if (tipo.equals("todos")) {
            return clienteService.listAllCliente();
        } else {
            return clienteService.buscarPorFiltro(tipo, valor);
        }
    }

 	@PostMapping("/guardar")
 	@ResponseBody
 	public String addCliente(@RequestBody Cliente cliente) {
 		clienteService.addCliente(cliente);
 		return "Cliente guardado correctamente";
 	}
 	
    @GetMapping("/editar/{id}")
    @ResponseBody
    public Cliente getCliente(@PathVariable("id") int id) {
        return clienteService.getClienteById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String deleteCliente(@PathVariable("id") int id) {
        clienteService.deleteCliente(id);
        return "Cliente eliminado correctamente";
    }
    
    @GetMapping("/nuevo")
    public String nuevoCliente() {
        return "Cliente/NuevoCliente";
    }

    @GetMapping("/gestionar")
    public String gestionarCliente() {
        return "Cliente/GestionCliente";
    }
}