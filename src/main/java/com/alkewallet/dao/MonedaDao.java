package com.alkewallet.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alkewallet.model.Moneda;

public class MonedaDao extends Dao{
	
    public int insertar(Moneda moneda) {
        String stInsert = "INSERT INTO moneda (currency_name, currency_symbol) VALUES ('" + 
                moneda.getCurrencyName() + "', '" + 
                moneda.getCurrencySymbol() + "')";

		int insert = actualizarBaseDatos(stInsert);

		return insert;
	}

	public List<Moneda> consultar() throws SQLException {
		
		List<Moneda> listCurrency = new ArrayList<>();
		String query = "SELECT currency_id, currency_name, currency_symbol  FROM moneda";
		
		ResultSet rs = realizarConsulta(query);
		
		while(rs.next()) {
			Moneda currency = new Moneda();
			currency.setId(rs.getInt("currency_id"));
			currency.setCurrencyName(rs.getString("currency_name"));
			currency.setCurrencySymbol(rs.getString("currency_symbol"));
			listCurrency.add(currency);
		}
		return listCurrency;	
	}

    
    public Moneda ActualizarMoneda(Moneda moneda) {
        String stUpdate = "UPDATE moneda SET currency_name = '" + moneda.getCurrencyName() + "', currency_symbol = '" + moneda.getCurrencySymbol() + "'WHERE id = " + moneda.getId();
        actualizarBaseDatos(stUpdate);
        return moneda;
    }
	

	public int eliminar(int id) {
		String stDelete = "DELETE FROM moneda WHERE id = " + id;
		int delete = actualizarBaseDatos(stDelete);
		return delete;
	}
}
