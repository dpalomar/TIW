<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hola tu nombre es: <%=request.getParameter("nombre") %></h1>
<h3>y tu clave es: <%=request.getParameter("clave") %></h3>
<h4>¿tienes algo que decirme? (Atributos añadidos al request) <%=request.getAttribute("miAtributo") %></h4>
<h5>
<%
	String autenticado = (String)session.getAttribute("autenticado");
		if(autenticado !=null) {
			if(autenticado.equalsIgnoreCase("si")){
			%>
		Te has autenticado correctamente: (lo mantengo en sesión)
		<%
			}
			if(autenticado.equalsIgnoreCase("no")){ %>
		No te has autenticado correctamente, debes pasar por el 
		<a href="login.jsp">formulario</a>
				
		<%	}
	}
	
else{
%>
¡Eh! No puedes estar aquí
<%  } %>
</h5>
</body>
</html>