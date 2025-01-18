package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.CategoriaService;

@Service("categoriaservice")
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	@Qualifier("categoriarepository")
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> listAllCategoria() {
		return categoriaRepository.findAll();
	}
	@Override
	public Categoria addCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	@Override
    public void deleteCategoria(int id) {
        categoriaRepository.deleteById(id);
    }
    @Override
    public Categoria getCategoriaById(int id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Categoria> buscarPorFiltro(String tipo, String valor) {
        switch (tipo) {
            case "descripcion":
                return categoriaRepository.findByDescripcionContaining(valor);
            default:
                return listAllCategoria();
        }
    }
}