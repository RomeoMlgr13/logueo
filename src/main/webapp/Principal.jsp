<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
HttpSession seccion = (HttpSession) request.getSession();
String usuariovariabledeseccion = (String)seccion.getAttribute("usuario");
if(usuariovariabledeseccion == null){
	
	response.sendRedirect("index.jsp");
}

%>
<body>

<form action="ServeletUser" method="post">
<input type="submit" value="CERRAR" name="btncerrar">


</form>

<h1>hola mundo</h1>

</body>
</html>