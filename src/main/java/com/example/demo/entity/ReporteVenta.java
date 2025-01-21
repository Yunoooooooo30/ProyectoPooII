package com.example.demo.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cabecera_venta")
public class ReporteVenta{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cabecera")
	private int idCabecera;
	@Column(name="id_cliente")
	private int idCliente;
	@Column(name="valor_pagar")
	private double valorPagar;
	@Column(name="fecha_venta")
	private Date fechaVenta;
	@Column(name="estado")
	private int estado = 1;

	public ReporteVenta() {
	}

	public ReporteVenta(int idCabecera, int idCliente, double valorPagar, Date fechaVenta, int estado) {
		super();
		this.idCabecera = idCabecera;
		this.idCliente = idCliente;
		this.valorPagar = valorPagar;
		this.fechaVenta = fechaVenta;
		this.estado = estado;
	}
	
	public int getIdCabecera() {
		return idCabecera;
	}
	public void setIdCabecera(int idCabecera) {
		this.idCabecera = idCabecera;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getValorPagar() {
		return valorPagar;
	}
	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(java.util.Date date) {
		this.fechaVenta = date;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}