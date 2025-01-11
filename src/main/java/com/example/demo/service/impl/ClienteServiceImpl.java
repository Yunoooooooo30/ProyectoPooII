package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;

@Service("clienteservice")
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	@Qualifier("clienterepository")
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listAllCliente() {
		return clienteRepository.findAll();
	}
	@Override
	public Cliente addCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	@Override
	public void deleteCliente(int id) {
		clienteRepository.deleteById(id);
	}
	@Override
	public Cliente getClienteById(int id) {
		return clienteRepository.findById(id).orElse(null);
	}
}