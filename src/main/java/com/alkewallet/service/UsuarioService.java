package com.alkewallet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alkewallet.dao.UsuarioDao;
import com.alkewallet.model.Usuario;

public class UsuarioService {
	
	private UsuarioDao dao;
	
	public UsuarioService() {
		this.dao = new UsuarioDao();
	}
	
	public int insertarUsuario(Usuario usuario) {	
		int resultado = this.dao.insertar(usuario);
		return resultado;
	}
	
	public List<Usuario> obtenerUsuarios() throws SQLException{
		List<Usuario> listUser = new ArrayList<>();
		listUser = this.dao.consultar();
		return listUser;
	}
	
	public int eliminarUsuario(int id) {
		int resultado = this.dao.eliminar(id);
		return resultado;
	}

	public int ObtenerIdUsuario(String nombre) {
		// TODO Auto-generated method stub
		int resultado = this.dao.buscarId(nombre);
		return resultado;
	}
	
	public double ActualizarSaldo(int user_id, Double saldo ) {
		Double resultado = this.dao.actualizarSaldo(user_id, saldo);
		return resultado;
	}
	
	public double ObetenerSaldo(int user_id) {
		double resultado = this.dao.getSaldoById(user_id);
		return resultado;
	}
	
	public Usuario ObtenerUsuarioById(int user_id) {
		Usuario usuario = this.dao.buscarUsuarioById(user_id);
		return usuario;
	}

}
