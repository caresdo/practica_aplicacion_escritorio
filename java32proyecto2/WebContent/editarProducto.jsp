<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form name="formProducto" action="ServletGuardarCambioProducto" method="post"><br>
	nombre: <input type="text" name="nombre" value="${productoEditar.nombre}"><br>
	cantidad: <input type="text" name="cantidad" value="${productoEditar.cantidad}"><br>
	precio: <input type="text" name="precio" value="${productoEditar.precio}"><br>
	oferta: <input type="text" name="oferta" value="${productoEditar.oferta}"><br>
	fecha de caducidad: <input type="text" name="fechaCad" value="${productoEditar.fechaCad}"><br>
	proveedor: <input type="text" name="proveedor" value="${productoEditar.proveedor}"><br>
	comentario: <input type="text" name="comentario" value="${productoEditar.comentario}"><br>
	<input type = "hidden" name = "id" value="${productoEditar.id}">
	<input type="submit" value="aceptar" />
	</form>
</body>
</html>