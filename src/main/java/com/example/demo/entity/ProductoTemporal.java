package com.example.demo.entity;

public class ProductoTemporal {
	private int id_producto;
    private String codigo;
    private String marca;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private int igv;
    private String categoriaDescripcion;  // Descripción de la categoría

    // Constructor
    public ProductoTemporal(int id_producto, String codigo, String marca, String nombre, int cantidad, double precio, 
                                    String descripcion, int igv, String categoriaDescripcion) {
    	this.id_producto = id_producto;
        this.codigo = codigo;
        this.marca = marca;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.igv = igv;
        this.categoriaDescripcion = categoriaDescripcion;
    }

    // Getters y Setters
    public int getId_producto() { return id_producto; }
    public void setId_producto(int id_producto) { this.id_producto = id_producto; }
    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getIgv() { return igv; }
    public void setIgv(int igv) { this.igv = igv; }

    public String getCategoriaDescripcion() { return categoriaDescripcion; }
    public void setCategoriaDescripcion(String categoriaDescripcion) { this.categoriaDescripcion = categoriaDescripcion; }
}