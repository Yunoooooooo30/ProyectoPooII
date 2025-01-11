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
	private int id_cliente;
	@Column(name="dni_ruc")
    private String dni_ruc;
	@Column(name="tipo_documento")
    private String tipo_documento;
	@Column(name="nombre")
    private String nombre;
	@Column(name="celular")
    private String celular;
	@Column(name="direccion")
    private String direccion;
	@Column(name="estado")
    private int estado;

    public Cliente(){
    }

    public Cliente(int id_cliente, String dni_ruc, String tipo_documento, String nombre, String celular, String direccion, int estado){
        super();
    	this.id_cliente = id_cliente;
        this.dni_ruc = dni_ruc;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getId_cliente(){
        return id_cliente;
    }
    public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public String getDni_ruc(){
        return dni_ruc;
    }
    public void setDni_ruc(String dni_ruc){
        this.dni_ruc = dni_ruc;
    }
    public String getTipo_documento(){
        return tipo_documento;
    }
    public void setTipo_documento(String tipo_documento){
        this.tipo_documento = tipo_documento;
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
