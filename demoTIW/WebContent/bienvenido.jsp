<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hola tu nombre es: <c:out value="${param.nombre }"></c:out> </h1>
<h3>y tu clave es: <c:out value="${param.clave }"></c:out> </h3>
<h4>¿tienes algo que decirme? (Atributos añadidos al request) <c:out value="${miAtributo }"></c:out> </h4>
<h5>
<c:set var="auten" scope="session" value="${sessionScope.autenticado }"></c:set>

<c:choose>
 <c:when test="${auten!=null }">
	<c:choose>
		<c:when test="${auten=='si' }">
		<p>Te has autenticado correctamente: (lo mantengo en sesión)</p>
		<p>¿Quieres ver la lista de todos los usuarios de la bbdd? <a href="gestionusuarios?accion=verlista">Ver lista</a></p>
		</c:when>
		<c:when test="${auten=='no' }">
			<p>No te has autenticado correctamente, debes pasar por el </p>
			
		<a href="login.jsp">formulario</a>
		</c:when>
	</c:choose>
	</c:when>
	<c:otherwise>
	<p> ¡Eh! No puedes estar aquí</p>
	</c:otherwise>
</c:choose>

</h5>
</body>
</html>