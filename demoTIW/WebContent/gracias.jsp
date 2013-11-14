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
<H1>${Mensaje } </H1>
<p>Desde aquí puedes volver a la <A href="index.jsp"> página principal</A> </p>
<P> O ver <a href="gestionusuarios?accion=verlista">Ver la lista de usuarios</a>
 </P>

<TABLE>
<TR><TD>

<P>¿Quieres modificar tus datos?  </P>

</TD>

<td>
<form method="post" action="gestionusuarios">
<INPUT type="hidden" name="accion" value="PRE_ACTUALIZAR"/>
<INPUT type="hidden" name="id" value="${user.id }"/>
<INPUT  type="submit" value="Modificar"/>
</form>

</td> </TR>

</TABLE>

</body>
</html>
</jsp:root>