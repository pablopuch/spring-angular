package com.xmlbackend.xmlbackend.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Zapa {
    public int id;
    public String marca;
    public String modelo;
    public int numero;
    public int stock;

    public Zapa(int id, String marca, int numero, int stock) {
		this.id = id;
		this.marca = marca;
		this.numero = numero;
		this.stock = stock;
	}

    public Zapa() {
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

    @Override
    public String toString() {
        return "Zapa{" +
                "id=" + id +
                ", marca=" + marca +
                ", modelo='" + modelo + '\'' +
                ", numero=" + numero +
                ", stock=" + stock +
                '}';
    }
}
