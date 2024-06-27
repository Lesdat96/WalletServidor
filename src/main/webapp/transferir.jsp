<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transferir Dinero</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<div class="container-xl">
			<nav class="navbar navbar-expand-lg navbar-light bg-white">
				<a class="navbar-brand" href="/AlkeWallet/sumar-saldo"><strong>A</strong>lke
					<strong>W</strong>allet</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="/AlkeWallet/sumar-saldo">Agregar saldo</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/AlkeWallet/retirar-saldo">Retirar saldo</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/AlkeWallet/realizar-transaccion">Transferir</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/AlkeWallet/login">Cambiar Usuario</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/AlkeWallet/inicio">Crear usuario</a></li>
					</ul>
				</div>
			</nav>
		</div>

		<hr>
	</header>
	<div class="container">
		<h3 class="pt-4">Transferir Dinero</h3>
		<form method="post" action="realizar-transaccion">
			<div class="form-group">
				<input type="number" name="sender_id" id="sender_id"
					class="form-control" value="${ sender_id }" hidden="true">
			</div>
			<div class="form-group">
				<label for="receiver_id">Selecciona el Receptor</label> <select
					name="receiver_id" id="receiver_id" class="form-control" required>
					<option value="">Selecciona un usuario</option>
					<c:forEach var="usuario" items="${sessionScope.listaUsuarios}">
						<option value="${usuario.id}">${usuario.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="importe">Importe</label> <input type="text"
					name="importe" id="importe" class="form-control" required>
			</div>
			<div class="form-group">
				<label for="moneda_currency_id">ID de Moneda</label> <input
					type="text" name="moneda_currency_id" id="moneda_currency_id"
					class="form-control" required>
			</div>
			<p>${errorMensaje}</p>
			<button type="submit" class="btn btn-primary">Transferir</button>
		</form>

		<h3 class="pt-4">Transacciones</h3>
		<c:choose>
			<c:when test="${empty sessionScope.listaTransacciones}">
				<div class="alert alert-warning" role="alert">No hay
					transacciones disponibles.</div>
			</c:when>
			<c:otherwise>
				<table class="table">
					<thead>
						<tr>
							<th>ID de Transacción</th>
							<th>ID del Remitente</th>
							<th>ID del Receptor</th>
							<th>Fecha de Transacción</th>
							<th>Importe</th>
							<th>ID de Moneda</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="transaccion"
							items="${sessionScope.listaTransacciones}">
							<tr>
								<td><c:out value="${transaccion.transaction_id}" /></td>
								<td><c:out value="${transaccion.sender_id}" /></td>
								<td><c:out value="${transaccion.receiver_id}" /></td>
								<td><c:out value="${transaccion.transaction_date}" /></td>
								<td><c:out value="${transaccion.importe}" /></td>
								<td><c:out value="${transaccion.moneda_currency_id}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
<style>
        body {
            background-color: #577CFB; /* Cambia a tu color preferido */
            color: #333333; /* Color del texto */
        }
        div 
        {background-color: #577CFB; /* Cambia a tu color preferido */
            color: #333333; /* Color del texto */
        }
    </style>
</html>
