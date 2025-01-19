package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Categoria;

@Repository("categoriarepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Serializable>{
	List<Categoria> findByDescripcionContaining(String descripcion);
}