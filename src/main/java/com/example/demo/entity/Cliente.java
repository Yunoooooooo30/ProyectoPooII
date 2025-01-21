package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;
	@Column(name="tipo_documento")
    private String tipoDocumento;
	@Column(name="dni_ruc")
    private String dniRuc;
	@Column(name="nombre")
    private String nombre;
	@Column(name="celular")
    private String celular;
	@Column(name="direccion")
    private String direccion;
	@Column(name="estado")
    private int estado = 1;

    public Cliente(){
    }

    
    public Cliente(int idCliente, String tipoDocumento, String dniRuc, String nombre, String celular, String direccion,
			int estado) {
    	super();
		this.idCliente = idCliente;
		this.tipoDocumento = tipoDocumento;
		this.dniRuc = dniRuc;
		this.nombre = nombre;
		this.celular = celular;
		this.direccion = direccion;
		this.estado = estado;
	}

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDniRuc() {
		return dniRuc;
	}
	public void setDniRuc(String dniRuc) {
		this.dniRuc = dniRuc;
	}
	public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getCelular(){
        return celular;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public int getEstado(){
        return estado;
    }
    public void setEstado(int estado){
        this.estado = estado;
    }
}