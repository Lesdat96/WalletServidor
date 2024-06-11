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

import com.alkewallet.model.Transaccion;
import com.alkewallet.service.TransaccionService;
import com.alkewallet.model.Usuario;
import com.alkewallet.service.UsuarioService;
import javax.servlet.ServletContext;

import java.time.LocalDate;

@WebServlet("/realizar-transaccion")public class TransaccionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransaccionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Transaccion> transaccionList = new ArrayList<>();
		List<Usuario> userList = new ArrayList<>();
		TransaccionService transaccionService = new TransaccionService();
		UsuarioService usuarioService = new UsuarioService();
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		Integer user_id = (Integer) context.getAttribute("user_id");

		try {
			transaccionList = transaccionService.obtenerTransacciones();
			userList = usuarioService.obtenerUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		session.setAttribute("listaUsuarios", userList);
		session.setAttribute("sender_id", user_id);
		session.setAttribute("errorMensaje", "");

		if (transaccionList.isEmpty()) {
			request.setAttribute("noTransacciones", true);
		} else {
			session.setAttribute("listaTransacciones", transaccionList);
		}

		request.getRequestDispatcher("/transferir.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// creación de objetos del método
		List<Usuario> userList = new ArrayList<>();
		List<Transaccion> transaccionList = new ArrayList<>();
		Transaccion transaccion = new Transaccion();
		TransaccionService transaccionService = new TransaccionService();
		TransaccionService service = new TransaccionService();
		UsuarioService user_service = new UsuarioService();
		LocalDate fechaActual = LocalDate.now();
		HttpSession session = request.getSession();

		// seteo el objeto producto con los valores del formulario
		Double importe = Double.valueOf(request.getParameter("importe"));
		Integer sender_id = Integer.valueOf(request.getParameter("sender_id"));
		Integer receiver_id = Integer.valueOf(request.getParameter("receiver_id"));

		transaccion.setSender_id(sender_id);
		transaccion.setReceiver_id(receiver_id);
		transaccion.setTransaction_date(String.valueOf(fechaActual));
		transaccion.setImporte(importe);
		transaccion.setMoneda_currency_id(Integer.valueOf(request.getParameter("moneda_currency_id")));

		double saldoEnCuentaSender = user_service.ObetenerSaldo(sender_id);
		double saldoEnCuentaReceiver = user_service.ObetenerSaldo(receiver_id);

		if ((saldoEnCuentaSender - importe) >= 0) {
			double saldoTotalSender = saldoEnCuentaSender - importe;
			double saldoTotalReceiver = saldoEnCuentaReceiver + importe;

			user_service.ActualizarSaldo(sender_id, saldoTotalSender);
			user_service.ActualizarSaldo(receiver_id, saldoTotalReceiver);
			int resultado = service.insertarTransaccion(transaccion);

			if (resultado > 0) {
				response.sendRedirect("/AlkeWallet/realizar-transaccion");
			}
		} else {
			try {
				transaccionList = transaccionService.obtenerTransacciones();
				userList = user_service.obtenerUsuarios();
				session.setAttribute("listaTransacciones", transaccionList);
				session.setAttribute("listaUsuarios", userList);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			session.setAttribute("errorMensaje", "No tienes suficiente saldo.");
			request.getRequestDispatcher("/transferir.jsp").forward(request, response);
		}
	}

}
