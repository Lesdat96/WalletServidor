package com.alkewallet.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alkewallet.dao.TransaccionDao;
import com.alkewallet.model.Transaccion;
public class TransaccionService {

	private TransaccionDao dao;
	
	public TransaccionService() {
		this.dao = new TransaccionDao();
	}
	
	public int insertarTransaccion(Transaccion transaccion) {	
		int resultado = this.dao.insertar(transaccion);
		return resultado;
	}
	
	public List<Transaccion> obtenerTransacciones() throws SQLException{
		List<Transaccion> listTransaccion = new ArrayList<>();
		listTransaccion = this.dao.consultar();
		return listTransaccion;
	}
	
	public int eliminarTransaccion(int id) {
		int resultado = this.dao.eliminar(id);
		return resultado;
	}
}
