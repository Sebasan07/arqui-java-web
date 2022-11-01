<%@page import="co.edu.ufps.web.model.*"%>
<%@page import="co.edu.ufps.web.dao.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../style.css">
<title>Registrar Candidato</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #38C953">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"><h1>Registrar
						Candidatos</h1> Candidatos Management App </a>
			</div>
		</nav>
	</header>

	<hr>
	<div id="botones" class="container text-left">
		
		<a href="<%=request.getContextPath()%>/CandidatoServlet?action=index" class="btn btn-success">Ir al
			men� candidatos</a> <a href="<%=request.getContextPath()%>/vistaCandidatos/mostrar.jsp"
			class="btn btn-success">Listar Candidatos</a>
	</div>

	<div class="container">
		<div class="card">
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/CandidatoServlet?action=register" method="post">
				
					<div class="form-group">
						<label for="validation01">Documento</label> <input type="text"
							class="form-control" placeholder="Documento" name="documento">
					</div>
					<div class="form-group">
						<label for="validation01">Nombre</label> <input type="text"
							class="form-control" placeholder="Nombre" name="nombre">
					</div>
					<div class="form-group">
						<label for="validation01">Apellido</label> <input type="text"
							class="form-control" placeholder="Apellido" name="apellido">
					</div>
					<div class="form-group">

       					
       					<select name="eleccion">
  						<option>Seleccionar eleccion</option> 
       					 <% for(Eleccion e: new EleccionDAO().list()){%>
          			 	<option value="<%=e.getId()%>"><%=e.getId()%> - <%=e.getNombre()%> </option>
       						 <% }%>
						</select>

					</div>
					<div class="form-group">
						<label for="validation01">Numero</label> <input type="number"
							class="form-control" placeholder="Numero" name="numero">
					</div>
					
						<input type="submit" class="btn btn-success" value="Agregar"
							name="agregar">
					
				</form>
			</div>
		</div>
	</div>

	<footer>
        <div class="row">
            <div class="col-md-3">
                <ul id="ul-con" type="none">
                    <b>Contacto</b>
                    <li>Email: juansebastiansp@ufps.edu.co</li>
                    <li>Cel: +57 3219810616</li>
                </ul>
            </div>
        </div>
        <hr>
        <p>2022 � All Rights Reserved </p>
    </footer>
</body>
</html>