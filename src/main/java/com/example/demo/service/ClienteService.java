package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cliente;

public interface ClienteService {
	List<Cliente> listAllCliente();
	Cliente addCliente(Cliente cliente);
    void deleteCliente(int id);
    Cliente getClienteById(int id);
    List<Cliente> buscarPorFiltro(String tipo, String valor);
}