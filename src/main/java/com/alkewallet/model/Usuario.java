package com.alkewallet.model;

public class Usuario {
	
	private int id;
	private String email;
	private String nombre;
	private Double saldo;
	private Integer currencyId;
	
	public Usuario(String usuario, String nombre, String email, Double saldo, Integer currencyId) {
		this.nombre = nombre;
		this.email = email;
		this.saldo = saldo;
		this.currencyId = currencyId;
	}
	
	public Usuario() {
		super();
	}
	
	public Integer getCurrencyId() {
		return currencyId;
	}
	
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
