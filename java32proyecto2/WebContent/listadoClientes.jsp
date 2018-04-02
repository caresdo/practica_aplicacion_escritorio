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
<h1>lista de Clientes</h1>
<a href="registrarCliente.jsp">registrar cliente</a>
<c:forEach items="${clientes}" var = "cliente">
	<div style="margin: 10px">
		nombre: ${cliente.nombre}<br>
		calle: ${cliente.calle} <br>
		numeracion: ${cliente.numeracion} <br>
		codigo postal: ${cliente.codigoPostal} <br>
		poblacion: ${cliente.poblacion} <br>
		telefono: ${cliente.telefono} <br>
		email: ${cliente.email} <br>
		particular o empresa: ${cliente.particularOEmpresa} <br>
		<a href="ServletBorrarCliente?id=${cliente.id}">borrar</a>
		<a href="ServletEditarCliente?id=${cliente.id}">editar</a>
	</div>
</c:forEach>
</body>
</html>