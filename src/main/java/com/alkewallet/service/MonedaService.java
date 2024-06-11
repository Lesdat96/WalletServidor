package com.alkewallet.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alkewallet.dao.MonedaDao;
import com.alkewallet.model.Moneda;

public class MonedaService {
	
	private MonedaDao dao;
	
	public MonedaService() {
		this.dao = new MonedaDao();
	}
	
	public int insertarMoneda(Moneda moneda) {	
		int resultado = this.dao.insertar(moneda);
		return resultado;
	}
	
	public List<Moneda> obtenerMoneda() throws SQLException{
		List<Moneda> listCurrency = new ArrayList<>();
		listCurrency = this.dao.consultar();
		return listCurrency;
	}
	
	public int eliminarUsuario(int id) {
		int resultado = this.dao.eliminar(id);
		return resultado;
	}
}
	
	
	
	