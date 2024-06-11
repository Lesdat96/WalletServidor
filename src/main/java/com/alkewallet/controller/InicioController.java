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

@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		session.setAttribute("listaMonedas", MonedaList );
		
		request.getRequestDispatcher("/crear_usuario.jsp").forward(request, response);
	}

}