package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_venta")
	private int idVenta;
	@Column(name="id_cabecera")
	private int idCabecera;
	@Column(name="id_producto")
	private int idProducto;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="precio_unitario")
	private double precioUnitario;
	@Column(name="descuento")
	private double descuento;
	@Column(name="igv")
	private double igv;
	@Column(name="total_pagar")
	private int totalPagar;
	@Column(name="estado")
	private int estado = 1;
	
	public Venta() {
	}

	public Venta(int idVenta, int idCabecera, int idProducto, int cantidad, double precioUnitario, double descuento,
			double igv, int totalPagar, int estado) {
		super();
		this.idVenta = idVenta;
		this.idCabecera = idCabecera;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.descuento = descuento;
		this.igv = igv;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdCabecera() {
		return idCabecera;
	}
	public void setIdCabecera(int idCabecera) {
		this.idCabecera = idCabecera;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getIgv() {
		return igv;
	}
	public void setIgv(double igv) {
		this.igv = igv;
	}
	public int getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(int totalPagar) {
		this.totalPagar = totalPagar;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}