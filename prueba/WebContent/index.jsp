<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {

		font-family: sans-serif;
		font-size: 62,5%;
		color: #9f9f9f;
	}
	fieldset input {
		padding 0.5em;
		display: block;
		border: 0.1em solid;
		
		background-color: lightgray;
	}
		fieldset input:FOCUS{
		background-color: white;
		}
</style>
</head>
<body>
<h1>Registro de usuarios	</h1>
		<form action="usuario" method="post">
		<fieldset>
			<legend>Registro Form</legend>
			<label for="nombre">Nombre:</label>
			<input type="text" id="nombre" name="nombre" size="40"/>
			<label for="password" >Clave:</label>
			<input type="password" id="password" name="password" size="40" />
		</fieldset>
		<input type="submit" value="Enviar"/>
		</form>


</body>
</html>