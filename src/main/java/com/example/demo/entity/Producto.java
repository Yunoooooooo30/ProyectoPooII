package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int id_producto;
	@Column(name="codigo")
    private String codigo;
	@Column(name="marca")
    private String marca;
	@Column(name="nombre")
    private String nombre;
	@Column(name="cantidad")
    private int cantidad;
	@Column(name="precio")
    private double precio;
	@Column(name="descripcion")
    private String descripcion;
	@Column(name="igv")
    private int igv;
	// Asegúrate de tener el ID de la categoría como un entero
    @Column(name = "id_categoria")
    private int id_categoria; // Esto debe ser un entero
	@Column(name="estado")
    private int estado = 1;

    public Producto(){
    }
   
    public Producto(int id_producto, String codigo, String marca, String nombre, int cantidad, double precio,
			String descripcion, int igv, int id_categoria, int estado) {
		this.id_producto = id_producto;
		this.codigo = codigo;
		this.marca = marca;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descripcion = descripcion;
		this.igv = igv;
		this.id_categoria = id_categoria;
		this.estado = estado;
	}

	public int getId_producto(){
        return id_producto;
    }
    public void setId_producto(int id_producto){
        this.id_producto = id_producto;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public int getIgv(){
        return igv;
    }
    public void setIgv(int igv){
        this.igv = igv;
    }
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getEstado(){
        return estado;
    }
    public void setEstado(int estado){
        this.estado = estado;
    }  
}