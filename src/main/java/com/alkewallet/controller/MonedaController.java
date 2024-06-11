package com.alkewallet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alkewallet.model.Moneda;
import com.alkewallet.service.MonedaService;


@WebServlet("/moneda")
public class MonedaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonedaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Moneda> MonedaList = new ArrayList<Moneda>();
		MonedaService service = new MonedaService();
		
		try {
			MonedaList = service.obtenerMoneda();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//sesion
		HttpSession session = request.getSession();
		session.setAttribute("listaProd", MonedaList );
		
		response.sendRedirect("listarProductos.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creación de objetos del método
		Moneda moneda = new Moneda();
		MonedaService service = new MonedaService();
		
		//seteo el objeto producto con los valores del formulario
		moneda.setCurrencyName(request.getParameter("currency_name"));
		moneda.setCurrencySymbol(request.getParameter("currency_symbol"));
		int resultado = service.insertarMoneda(moneda);
		
		
		if( resultado > 0) {
			response.sendRedirect("createUser.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
