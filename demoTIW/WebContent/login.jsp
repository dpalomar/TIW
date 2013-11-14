<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{ color:red; }
</style>
</head>
<body>
	<h1>Formulario de login</h1>
	<%
		boolean error = false;
		String autenticado = (String)session.getAttribute("autenticado");
		if(autenticado==null|| autenticado.equalsIgnoreCase("no") ){
			error = true;
			%>
		<h5 class="error">Tu usuario o clave no son correctas</h5>
	<%		
		}
	%>
	
	<form action="login" method="post">
		<fieldset>
			<legend>Login</legend>
			<label for="nom">Nombre:</label>
			<input type="text" id="nom" name="nombre"> <%if(error) out.println("<span class='error'>*</span>"); %>
			<br>
			<label for="password">Clave</label>
			<input type="password" id="password" name="clave"><%if(error) out.println("<span class='error'>*</span>"); %>
			<br>
			
		</fieldset>
		<input type="submit" value="Enviar">
	</form>
	<p><a href="registro.jsp"> Regístrate</a> </p>
</body>
</html>