<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<style>
html, body {
	height: 100vh;
}

.card-login {
	box-shadow: 2px 2px 10px 1px rgba(0, 0, 0, 0.2);
}

body {
	background-color: #ffffff;
}

.container {
	width: 600px;
	background-color: #fff;
	padding-top: 100px;
	padding-bottom: 100px;
}

.card {
	background-color: #fff;
	width: 300px;
	border-radius: 15px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.name {
	font-size: 15px;
	color: #403f3f;
	font-weight: bold;
}

.cross {
	font-size: 11px;
	color: #b0aeb7;
}

.pin {
	font-size: 14px;
	color: #b0aeb7;
}

.first {
	border-radius: 8px;
	border: 1.5px solid #78b9ff;
	color: #000;
	background-color: #eaf4ff;
}

.second {
	border-radius: 8px;
	border: 1px solid #acacb0;
	color: #000;
	background-color: #fff;
}

.head {
	color: #137ff3;
	font-size: 12px;
}

.dollar {
	font-size: 18px;
	color: #097bf7;
}

.amount {
	color: #007bff;
	font-weight: bold;
	font-size: 18px;
}

.form-control {
	font-size: 18px;
	font-weight: bold;
	width: 60px;
	height: 28px;
}

.back {
	color: #aba4a4;
	font-size: 15px;
	line-height: 73px;
	font-weight: 400;
}

.button {
	width: 150px;
	height: 60px;
	border-radius: 8px;
	font-size: 17px;
}
</style>
<body>

	<header>
		<div class="container-xl">
			<nav class="navbar navbar-expand-lg navbar-light bg-white">
				<strong>A</strong>lke
					<strong>W</strong>allet</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
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
		<div class="row">
			<div class="col"></div>
			<div class="col">

				<div class="card">
					<div class="card-body">
						<div class="d-flex pt-3">
							<div id="username" class="mt-3">
								<span class="name"></span>
								<div></div>
							</div>
						</div>
						<div class="card-body">
							<h3>Cargar Saldo</h3>
							<p>Nombre del usuario: ${nombre}</p>
							<p>Saldo: ${saldo}</p>
							<p>Correo: ${email}</p>
							<p>Id: ${id}</p>

						</div>
						<form action="/AlkeWallet/sumar-saldo" method="post">
							<input type="number" id="user_id" name="user_id" value="${id}"
								hidden="true"><br> <label for="saldo">Saldo
								a cargar:</label> <input class="shadow rounded my-2 w-100 border"
								type="number" id="saldo" name="saldo" required><br>
							<input class="btn btn-rounded btn-primary w-100" type="submit"
								value="Cargar">
						</form>
					</div>
				</div>
			</div>
			<div class="col"></div>
		</div>
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
	<script src="script.js">
		
	</script>
</body>
