package com.alkewallet.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alkewallet.model.Usuario;
import com.alkewallet.service.UsuarioService;

@WebServlet("/retirar-saldo")
public class RestarSaldoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestarSaldoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService service = new UsuarioService();
		
		//creación de objetos del método
		int id = Integer.valueOf(request.getParameter("user_id"));
		double saldo = Integer.valueOf(request.getParameter("saldo"));
		HttpSession session = request.getSession();
		Usuario usuario = null;
		
		try {
			usuario = service.ObtenerUsuarioById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double saldoEnCuenta = service.ObetenerSaldo(id);
		
		if ((saldoEnCuenta - saldo) >= 0) {
			double saldoTotal = saldoEnCuenta - saldo;

			service.ActualizarSaldo(id, saldoTotal);

			session.setAttribute("mensaje", "" );
			session.setAttribute("saldo", saldoTotal );
			
			request.getRequestDispatcher("/restar_saldo.jsp").forward(request, response);
		} else {
			session.setAttribute("mensaje", "Saldo insuficiente." );
			session.setAttribute("id", usuario.getId());
			session.setAttribute("nombre", usuario.getNombre());
			session.setAttribute("email", usuario.getEmail());
			session.setAttribute("saldo", saldoEnCuenta );
			
			request.getRequestDispatcher("/restar_saldo.jsp").forward(request, response);
			}
		}
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService service = new UsuarioService();
		ServletContext context = getServletContext();
		
		Integer user_id = (Integer) context.getAttribute("user_id");
		Usuario usuario = service.ObtenerUsuarioById(user_id);
		
		//sesion
		HttpSession session = request.getSession();
		session.setAttribute("id", usuario.getId());
		session.setAttribute("nombre", usuario.getNombre());
		session.setAttribute("email", usuario.getEmail());
		session.setAttribute("saldo", usuario.getSaldo());
		session.setAttribute("mensaje", "");
		
		request.getRequestDispatcher("/restar_saldo.jsp").forward(request, response);
}
}