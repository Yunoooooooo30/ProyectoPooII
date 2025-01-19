package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Categoria;

public interface CategoriaService {
	public abstract List<Categoria> listAllCategoria();
	Categoria addCategoria(Categoria categoria);
    void deleteCategoria(int id);
    Categoria getCategoriaById(int id);	
    List<Categoria> buscarPorFiltro(String tipo, String valor);
}