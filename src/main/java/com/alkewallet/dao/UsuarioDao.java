package com.alkewallet.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alkewallet.model.Usuario;

public class UsuarioDao extends Dao{
	
	
    public int insertar(Usuario usuario) {
		String stInsert = "INSERT INTO usuario (nombre, correo_electronico, saldo, moneda_currency_id) VALUES ('" + 
				usuario.getNombre() + "', '" + 
				usuario.getEmail()+"', '" + 
				usuario.getSaldo() + "', '" + 
				usuario.getCurrencyId()+"')";

		int insert = actualizarBaseDatos(stInsert);

		return insert;
	}
	

	public List<Usuario> consultar() throws SQLException {
		
		List<Usuario> listUser = new ArrayList<>();
		String query = "SELECT user_id, nombre, correo_electronico, saldo, moneda_currency_id FROM usuario";
		
		ResultSet rs = realizarConsulta(query);
		System.out.print(rs);
		
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("user_id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setEmail(rs.getString("correo_electronico"));
			usuario.setSaldo(Double.valueOf(rs.getString("saldo")));
			usuario.setCurrencyId(rs.getInt("moneda_currency_id"));
			listUser.add(usuario);
		}
		return listUser;
	}

    
    public Usuario actualizar(Usuario usuario) {
        String stUpdate = "UPDATE usuario SET nombre = '" + usuario.getNombre() + "', correo_electronico = '" + usuario.getEmail() + "', moneda_currency_id = '" + usuario.getCurrencyId() + "' WHERE user_id = " + usuario.getId();
        actualizarBaseDatos(stUpdate);
        return usuario;
    }
    
    public double actualizarSaldo(int id, double saldo) {
    	System.out.print(id);
        String stUpdate = "UPDATE usuario SET saldo = '" + saldo + "' WHERE user_id = " + id;
        actualizarBaseDatos(stUpdate);
        return saldo;
    }
	

	public int eliminar(int id) {
		String stDelete = "DELETE FROM usuario WHERE user_id = "+id;
		int delete = actualizarBaseDatos(stDelete);
		return delete;
	}
	
	public Usuario  buscarUsuarioById(int id) {
		Usuario usuario4 = new Usuario();
	    try {
	        // Consulta SQL para obtener el ID del usuario a partir de su nombre
	    	String query = "SELECT user_id, nombre, correo_electronico, saldo FROM usuario WHERE user_id = '" + id + "'";
	        ResultSet rs = realizarConsulta(query);
	        // Ejecutar la consulta
	        // Verificar si se encontró el usuario en la base de datos
	        if (rs.next()) {
	            // Crear un objeto Usuario con los datos obtenidos de la base de datos

	            usuario4.setId(rs.getInt("user_id"));
	            usuario4.setNombre(rs.getString("nombre"));
	            usuario4.setEmail(rs.getString("correo_electronico"));
	            usuario4.setSaldo(Double.valueOf(rs.getString("saldo")));
	            return usuario4;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	    
	    return usuario4;
	}
	
	public int buscarId(String usuario) {
	    try {
	        // Consulta SQL para obtener el ID del usuario a partir de su nombre
	    	String query = "SELECT user_id FROM usuario WHERE nombre = '" + usuario + "'";
	        
	        ResultSet rs = realizarConsulta(query);
	        // Ejecutar la consulta
	        // Verificar si se encontró el usuario en la base de datos
	        if (rs.next()) {
	            // Crear un objeto Usuario con los datos obtenidos de la base de datos
	            Usuario usuario1 = new Usuario();
	            usuario1.setId(rs.getInt("user_id"));
	            int id = usuario1.getId();
	            return id;
	        } else {
	            // Manejar el caso en que no se encuentra el usuario en la base de datos
	            return 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return 0;
	}
	
	public double getSaldoById(Integer id) {
	    try {
	        // Consulta SQL para obtener el ID del usuario a partir de su nombre
	    	String query = "SELECT saldo FROM usuario WHERE user_id = '" + id + "'";
	        
	        ResultSet rs = realizarConsulta(query);
	        // Ejecutar la consulta
	        // Verificar si se encontró el usuario en la base de datos
	        if (rs.next()) {
	            // Crear un objeto Usuario con los datos obtenidos de la base de datos
	            Usuario usuario2 = new Usuario();
	            usuario2.setSaldo(Double.valueOf(rs.getInt("saldo")));
	            double saldo = usuario2.getSaldo();
	            return saldo;
	        } else {
	            // Manejar el caso en que no se encuentra el usuario en la base de datos
	            System.out.println("El usuario no se encuentra en la base de datos.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return 0;
	}

}
