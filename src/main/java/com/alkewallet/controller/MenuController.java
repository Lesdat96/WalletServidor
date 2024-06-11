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

@WebServlet("/menu")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService usuarioService = new UsuarioService();
		ServletContext context = getServletContext();
		Integer user_id = (Integer) context.getAttribute("user_id");
		HttpSession session = request.getSession();
		Usuario usuario = usuarioService.ObtenerUsuarioById(user_id);
		session.setAttribute("nombre", usuario.getNombre());
		session.setAttribute("email", usuario.getEmail());
		session.setAttribute("saldo", usuario.getSaldo());
		session.setAttribute("id", usuario.getId());
		
		//sesion
		request.getRequestDispatcher("/menu.jsp").forward(request, response);
	}

}