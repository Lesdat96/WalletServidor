package com.alkewallet.controller;

import javax.servlet.ServletContext;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alkewallet.model.Usuario;
import com.alkewallet.service.UsuarioService;


@WebServlet("/sumar-saldo")
public class SaldoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaldoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService service = new UsuarioService();
		
		//creación de objetos del método
		int id = Integer.valueOf(request.getParameter("user_id"));
		double saldo = Integer.valueOf(request.getParameter("saldo"));
		
		Usuario usuario = null;
		
		try {
			usuario = service.ObtenerUsuarioById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double saldoEnCuenta = service.ObetenerSaldo(id);
		double saldoTotal = saldo + saldoEnCuenta;

		double resultado = service.ActualizarSaldo(id, saldoTotal);

		HttpSession session = request.getSession();
		session.setAttribute("saldo", saldoTotal );
		
		if( resultado > 0) {
			response.sendRedirect("/AlkeWallet/menu");
		} else {
			response.sendRedirect("error.jsp");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService service = new UsuarioService();
		ServletContext context = getServletContext();
		
		Integer user_id = (Integer) context.getAttribute("user_id");
		Usuario usuario = service.ObtenerUsuarioById(user_id);
		
		//sesion
		HttpSession session = request.getSession();
		session.setAttribute("user_id", usuario.getId());
		session.setAttribute("nombre", usuario.getNombre());
		session.setAttribute("email", usuario.getEmail());
		session.setAttribute("saldo", usuario.getSaldo());
		
		request.getRequestDispatcher("/menu.jsp").forward(request, response);
}
}