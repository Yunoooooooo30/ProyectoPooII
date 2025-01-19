package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Cliente;

@Repository("clienterepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable>{
	List<Cliente> findByTipoDocumentoContaining(String tipoDocumento);
	List<Cliente> findByDniRucContaining(String dniRuc);
	List<Cliente> findByNombreContaining(String nombre);
}