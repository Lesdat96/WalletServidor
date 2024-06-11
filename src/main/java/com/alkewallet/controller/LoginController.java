package com.alkewallet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import com.alkewallet.model.Usuario;
import com.alkewallet.service.UsuarioService;

@WebServlet("/login")
public class LoginController extends HttpServlet { // Extiende HttpServlet
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}


		protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			// sesion
			
			HttpSession session = request.getSession();
			session.setAttribute("mensaje", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// creación de objetos del método
		ServletContext context = getServletContext();
		Usuario usuario = new Usuario();
		UsuarioService service = new UsuarioService();
		HttpSession session = request.getSession();
		// seteo el objeto usuario con los valores del formulario
		usuario.setNombre(request.getParameter("nombre"));

		int id_request = service.ObtenerIdUsuario(usuario.getNombre());
		if (id_request != 0) {

			context.setAttribute("user_id", id_request);
			response.sendRedirect("/AlkeWallet/menu");
		} else {
			session.setAttribute("mensaje", "El usuario no existe");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
