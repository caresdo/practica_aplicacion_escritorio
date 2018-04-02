<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/estilo.css" />
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form name="formCliente" action="ServletGuardarCambioCliente" method="post" onsubmit="return validarCliente()"><br>
	nombre: <input type="text" name="nombre" value="${clienteEditar.nombre}"><br>
	calle: <input type="text" name="calle" value="${clienteEditar.calle}"><br>
	numeracion: <input type="text" name="numeracion" value="${clienteEditar.numeracion}"><br>
	codigo postal: <input type="text" name="codigoPostal" value="${clienteEditar.codigoPostal}"><br>
	poblacion: <input type="text" name="poblacion" value="${clienteEditar.poblacion}"><br>
	telefono: <input type="text" name="telefono" value="${clienteEditar.telefono}"><br>
	email: <input type="text" name="email" value="${clienteEditar.email}"><br>
	particular o empresa: <input type="text" name="particularOEmpresa" value="${clienteEditar.particularOEmpresa}"><br>
	<input type = "hidden" name = "id" value="${clienteEditar.id}">
	<input type="submit" value="aceptar" />
	</form>
	
	<script type="text/javascript" src="js/validarCliente.js"></script>
</body>
</html>