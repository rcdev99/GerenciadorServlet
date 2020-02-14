<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro JSP</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp" />

	<c:if test="${not empty objeto}">
		Objeto: ${objeto} cadastrado com sucesso !
	</c:if>
	
	<c:if test="${empty objeto}">
		Nenhum objeto cadastrado
	</c:if>
	
</body>
</html>