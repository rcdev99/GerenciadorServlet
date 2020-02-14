<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletLogin"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${linkServletLogin} " method="post">
	
		<div>
			<input type="hidden" name="acao" value="ActionLogin" />
	        <label for="login">Login</label>
	        <input type="text" name="login" size="30" />
	        <br><br>
	        <label for="senha">Senha</label>
	        <input type="password" name="senha" size="30" />
        	<br><br>
        </div>
	
		<input type="submit" value="Acessar"/>
	</form>
</body>
</html>