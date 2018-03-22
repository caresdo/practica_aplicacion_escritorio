<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test="${sessionScope.identificado == null}">
	<jsp:forward page="index.jsp"></jsp:forward>
</c:if>

<a href="ServletListadoClientes">gestion clientes</a>&nbsp;
<a href="ServletListadoProductos">gestion Productos</a>&nbsp;
<a href="ServletLogOut">desconectar</a>&nbsp;
<br>
