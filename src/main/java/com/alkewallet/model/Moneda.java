package com.alkewallet.model;


public class Moneda {
	private Integer id;
	private String currencyName;
	private String currencySymbol;
	
	public Moneda(String currencyName, String currencySymbol) {
		this.setCurrencyName(currencyName);
		this.setCurrencySymbol(currencySymbol);
	}

	public Moneda() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
