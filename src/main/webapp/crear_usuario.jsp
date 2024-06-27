<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.List" %>
<%@ page import="com.alkewallet.model.Moneda" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Usuario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .card-center {
            margin: 0 auto;
            float: none;
            margin-top: 100px;
        }
		.navbar-nav {
            margin: auto;
        }
    </style>
</head>
<body>
    <header>
        <div class="container-xl">
            <nav class="navbar navbar-expand-lg navbar-light bg-white">
                <div class="navbar-collapse collapse justify-content-center">
                    <a class="navbar-brand" ><strong>A</strong>lke <strong>W</strong>allet</a>
                </div>
            </nav>
        </div>
        <hr>
    </header>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card card-center rounded shadow">
                    <div class="card-body">
                        <h3 class="card-title text-center">Crear Usuario</h3>
                        <form action="/AlkeWallet/usuarios" method="post">
                            <div class="form-group">
                                <label for="nombre">Nombre de usuario:</label>
                                <input type="text" id="nombre" name="nombre" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="moneda">Moneda:</label>
                                <select id="moneda" name="moneda" class="form-control">
                                    <%
                                        List<Moneda> listaMonedas = (List<Moneda>) session.getAttribute("listaMonedas");
                                        if (listaMonedas != null) {
                                            for (Moneda moneda : listaMonedas) {
                                                out.println("<option value=\"" + moneda.getId() + "\">" + moneda.getCurrencyName() + "</option>");
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="saldo">Saldo inicial:</label>
                                <input type="number" id="saldo" name="saldo" class="form-control" required>
                            </div>
                            <div class="text-center">
                                <input type="submit" value="Crear Usuario" class="btn btn-primary">
                            </div>
                        </form>
                        <c:if test="${not empty mensaje}">
                            <div class="alert alert-info mt-3" role="alert">
                                ${mensaje}
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
