package com.coderhouse.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Ventas")
public class Ventas {
	
	@Id
	private Integer nroDeTicket;
	
	@Column(name="Total")
	private double total;
	
	@Column(name="Metodo de pago")
	private String metodoDePago;
	
	public Ventas() 
	{
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getMetodoDePago() {
		return metodoDePago;
	}
	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public Integer getNroDeTicket() {
		return nroDeTicket;
	}

	public void setNroDeTicket(Integer nroDeTicket) {
		this.nroDeTicket = nroDeTicket;
	}
	
}