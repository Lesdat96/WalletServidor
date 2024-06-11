package com.alkewallet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alkewallet.model.Transaccion;

public class TransaccionDao extends Dao{
	
    public int insertar(Transaccion transaccion) {
		String stInsert = "INSERT INTO transaccion (sender_user_id, receiver_id, transaction_date, importe, moneda_currency_id) VALUES ('" +
							transaccion.getSender_id() + "', '" + 
							transaccion.getReceiver_id() + "', '" + 
							transaccion.getTransaction_date() + "', '" + 
							transaccion.getImporte() + "', '" + 
							transaccion.getMoneda_currency_id() + "')";

		int insert = actualizarBaseDatos(stInsert);

		return insert;
	}

    	
    	public List<Transaccion> consultar() throws SQLException {
            List<Transaccion> transaccionList = new ArrayList<>();
            String query = "SELECT transaction_id, sender_user_id, receiver_id, transaction_date, importe, moneda_currency_id FROM transaccion";

            ResultSet rs = realizarConsulta(query);
             while (rs.next()) {
                    Transaccion transaccion = new Transaccion();
                    transaccion.setTransaction_id(rs.getInt("transaction_id"));
                    transaccion.setSender_id(rs.getInt("sender_user_id"));
                    transaccion.setReceiver_id(rs.getInt("receiver_id"));
                    transaccion.setTransaction_date(rs.getString("transaction_date"));
                    transaccion.setImporte(rs.getDouble("importe"));
                    transaccion.setMoneda_currency_id(rs.getInt("moneda_currency_id"));
                    transaccionList.add(transaccion);
                }
            return transaccionList;
        }
    	
    public Transaccion actualizar(Transaccion transaccion) {
        String stUpdate = "UPDATE transaccion SET sender_user_id = '" + transaccion.getReceiver_id() + "',  sender_id = '" + transaccion.getSender_id() + "', importe = '" + transaccion.getImporte() + "', moneda_currency_id = '" + transaccion.getMoneda_currency_id() + "' WHERE user_id = " + transaccion.getTransaction_id();
        actualizarBaseDatos(stUpdate);
        return transaccion;
    }
    
	public int eliminar(int id) {
		String stDelete = "DELETE FROM transaccion WHERE user_id = " + id;
		int delete = actualizarBaseDatos(stDelete);
		return delete;
	}

}
