<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	p {
		font: bolder;
	}
</style>
</head>
<body>
<p>

	${saludo } ${usuario.nombre }, Te has registrado correctamente y ademas: 2 + 3 = ${suma } <br/>
	Si quieres añadir una direccion hazlo en este <a href="direccion.jsp?id=${usuario.id }">enlace</a>

</p>

</body>
</html>