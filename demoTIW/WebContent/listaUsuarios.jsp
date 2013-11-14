<?xml version="1.0" encoding="UTF-8" ?>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<title>Insert title here</title>
</head>
<body>
<p>Volver a  <A href="index.jsp"> página principal</A></p>
     <table>
                <caption>Lista Usuarios</caption>
                <thead>
                        <tr>
                                <th>Nombre</th>
                                <th>Clave</th>
                        </tr>
                </thead>
                <c:forEach items="${listausuarios }" var="usuario">

                        <tr>
                                <td><c:out value="${usuario.nombre }"></c:out></td>
                                <td><c:out value="${usuario.password }"></c:out></td>
                                <td><a href="gestionusuarios?id=${usuario.id }&accion=PRE_ACTUALIZAR">Editar</a> </td>
                                <td><a href="gestionusuarios?id=${usuario.id }&accion=BORRAR">Borrar</a> </td>
                        </tr>



                </c:forEach>
        </table>
</body>
</html>
