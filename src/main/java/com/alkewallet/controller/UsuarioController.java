package com.alkewallet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alkewallet.model.Usuario;
import com.alkewallet.service.UsuarioService;
import javax.servlet.ServletContext;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creación de objetos del método
		Usuario usuario = new Usuario();
		UsuarioService service = new UsuarioService();
		ServletContext context = getServletContext();
		
		//seteo el objeto producto con los valores del formulario
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSaldo(Double.valueOf(request.getParameter("saldo")));
		usuario.setCurrencyId(Integer.valueOf(request.getParameter("moneda")));
		
		int id_request = service.ObtenerIdUsuario(usuario.getNombre());
		if (id_request != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("mensaje", "El usuario ya existe" );
			
			response.sendRedirect("/AlkeWallet/inicio");
			
		} else {
			int resultado = service.insertarUsuario(usuario);
			int id = service.ObtenerIdUsuario(usuario.getNombre());
			context.setAttribute("user_id", id);
			
			if( resultado > 0) {
				response.sendRedirect("/AlkeWallet/menu");
			} else {
				response.sendRedirect("error.jsp");
		}
	}
	}
}
