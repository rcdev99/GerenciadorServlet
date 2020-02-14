<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletCadastrarAlgo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastra de Objetos</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />
	
	<form action="${linkServletCadastrarAlgo} " method="post">
	
		<div>
			<input type="hidden" name="acao" value="ActionCadastrarObjetos" />
	        <label for="objeto">Objeto</label>
	        <input type="text" name="objeto" size="30" />
        </div>
	
		<input type="submit"/>
	</form>
</body>
</html>