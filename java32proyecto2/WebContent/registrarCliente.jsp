<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/validacionCliente.js"></script>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
	

	<p>introduce los datos de cliente</p>
	<form name="formCliente" action="ServletRegistroCliente" method="post"><br>
	nombre: <input type="text" name="nombre"><br>
	calle: <input type="text" name="calle"><br>
	numeracion: <input type="text" name="numeracion"><br>
	codigo postal: <input type="text" name="codigoPostal"><br>
	poblacion: <input type="text" name="poblacion"><br>
	telefono: <input type="text" name="telefono"><br>
	email: <input type="text" name="email"><br>
	particular o empresa: <input type="text" name="particularOEmpresa"><br>
	<input type="submit" value="aceptar" />
	</form>
	
</body>
</html>