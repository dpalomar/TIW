<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	${usuario.nombre } | 	${usuario.password } <a href="usuario?evento=borrar&id=${usuario.id }">Borrar</a> 
	<ol>
	<c:forEach items="${usuario.direcciones }" var="direccion">
	<li>${direccion.calle } | ${direccion.ciudad } | ${direccion.localidad } | ${direccion.codigoPostal }</li>
		
	
	</c:forEach>
	</ol>
</p>

</body>
</html>