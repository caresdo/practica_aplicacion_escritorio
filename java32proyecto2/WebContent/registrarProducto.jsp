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
	<form name="formCliente" action="ServletRegistroProducto" method="post"><br>
	nombre: <input type="text" name="nombre"><br>
	cantidad: <input type="text" name="cantidad"><br>
	precio: <input type="text" name="precio"><br>
	oferta: <input type="text" name="oferta"><br>
	fecha de caducidad: <input type="text" name="fechaCad"><br>
	proveedor: <input type="text" name="proveedor"><br>
	comentario: <input type="text" name="comentario"><br>
	<input type="submit" value="aceptar"/>
	</form>
	
</body>
</html>