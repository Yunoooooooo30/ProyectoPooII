package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Usuario;

@Repository("usuariorepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
	Usuario findByUsuarioAndPassword(String usuario, String password);
	List<Usuario> findByUsuarioContaining(String usuario);
	List<Usuario> findByNombreContaining(String nombre);
	List<Usuario> findByApellidoContaining(String apellido);
}