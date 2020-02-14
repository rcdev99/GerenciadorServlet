<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<c:url value="/entrada" var="linkServletAlterarAlgo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterando Objeto</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />
		
	<c:if test="${not empty objeto}">
		<form action="${linkServletAlterarAlgo}" method="POST">
		
			<div>
				<input type="hidden" name="acao" value="ActionAlterarObjetos" />
		        <input type="hidden" name="id" value="${objeto.id}" />
		        <br/>
		        <label for="objeto">Objeto</label>
		        <input type="text" name="nome" value="${objeto.nome}"/>
		        <br/>
		        <label for="data">Data de criação</label>
		        <input type="text" name="data" value="<fmt:formatDate value="${objeto.dtCadastro}" pattern="dd/MM/yyyy HH:mm"/>" readonly/>
	        </div>

			<input type="submit" value="Editar"/>
		</form>
	</c:if>
	
	<c:if test="${empty objeto}">
		Objeto inválido !
	</c:if>
		
		
</body>
</html>