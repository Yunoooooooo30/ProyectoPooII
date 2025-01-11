package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuario;

public interface UsuarioService {
	public abstract List<Usuario> listAllUsuario();
	Usuario addUsuario(Usuario usuario);
    void deleteUsuario(int id);
    Usuario getUsuarioById(int id);	
}