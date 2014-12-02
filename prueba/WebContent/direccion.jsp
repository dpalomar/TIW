<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input{display: block;}
</style>
</head>
<body>
<h1>Direccion </h1>
		<form action="usuario" method="post">
		<fieldset>
			<legend>Direccion Form</legend>
			<label for="calle">Calle:</label>
			<input type="text" id="calle" name="calle" size="40"/>
			<label for="ciudad" >Ciudad:</label>
			<input type="text" id="ciudad" name="ciudad" size="40" />
			<label for="localidad" >Localidad:</label>
			<input type="text" id="localidad" name="localidad" size="40" />
			<label for="cp" >CP:</label>
			<input type="number" id="cp" name="cp" size="5" required/>
			<input type="hidden" name="evento" value="direccion"/>
			<input type="hidden" name="idUsuario" value="${param.id }">
		</fieldset>
		<input type="submit" value="Enviar"/>
		</form>
</body>
</html>