<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="gestionusuarios">
		<FIELDSET>
			<LEGEND>Datos de usuario</LEGEND>
			
		<label for="nombre">Nombre: </label><input name="nombre" id="nombre"/><br />
		<label for="apellidos">Apellidos: </label><input name="apellidos" id="apellidos"/><br />
		<label for="email">Email: </label><input name="email" id="email"/><br />
		<label for="password">Clave: </label><input name="password" id="password" type="password"/><br />
		</FIELDSET>
		<FIELDSET>
			<LEGEND>Dirección</LEGEND>
			<label for="calle">Calle: </label><input name="calle" id="calle"/><br />
			<label for="poblacion">Población: </label><input name="poblacion" id="poblacion"/><br />
			<label for="cp">CP: </label><input name="cp" id="cp"/><br />
		</FIELDSET>
		
		<!-- Este campo oculto indica la acción que debe realizar el servlet -->
		<INPUT type="hidden" name="accion" value="GUARDAR" />
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>
</jsp:root>