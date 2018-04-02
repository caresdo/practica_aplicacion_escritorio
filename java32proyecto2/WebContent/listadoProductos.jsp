<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h1>lista de Productos</h1>
<a href="registrarProducto.jsp">registrar productos</a>
<c:forEach items="${productos}" var = "producto">
	<div style="margin: 10px">
		nombre: ${producto.nombre}<br>
		cantidad: ${producto.cantidad} <br>
		precio: ${producto.precio} <br>
		oferta: ${producto.oferta} <br>
		fecha caducidad: ${producto.fechaCad} <br>
		proveedor: ${producto.proveedor} <br>
		comentario: ${producto.comentario} <br>
		<a href="ServletBorrarProducto?id=${producto.id}">borrar</a>
		<a href="ServletEditarProducto?id=${producto.id}">editar</a>
	</div>
</c:forEach>
</body>
</html>