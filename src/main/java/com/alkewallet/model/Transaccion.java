package com.alkewallet.model;

public class Transaccion {
	
	private int transaction_id;
	private int sender_id;
	private int receiver_id;
	private double importe;
	private String transaction_date;
	private int moneda_currency_id;
	
	public Transaccion(Integer sender_id, Integer receiver_id, Double importe, String transaction_date, Integer moneda_currency_id ) {
		this.setSender_id(sender_id);
		this.setReceiver_id(receiver_id);
		this.setImporte(importe);
		this.setTransaction_date(transaction_date);
		this.setMoneda_currency_id(moneda_currency_id);
	}

	public Transaccion() {
		super();
	}
	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getMoneda_currency_id() {
		return moneda_currency_id;
	}

	public void setMoneda_currency_id(int moneda_currency_id) {
		this.moneda_currency_id = moneda_currency_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

}
