<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,br.com.alura.gerenciador.model.Objeto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<c:url value="/entrada" var="linkController"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de objetos</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp"/>
	
	<label for="user">Login</label>
	<input type="text" name="user" value="${usuarioLogado.login}" disabled/>
	<br>
	<br>
	<br>
	<br>
	<a href=${linkController}?acao=ActionNovoObjeto&id=${objeto.id}>Cadastrar novo objeto</a>
	<br>
	<br>
	
	<table border ='1'>
		<tr>
			<td align = "center">ID</td>
			<td align = "center">Tipo</td>
			<td align = "center">Data de cadastro</td>
			<td align = "center">Ações</td>
		</tr>
		<c:forEach items="${objetos}" var="objeto">
		<tr>
			<td>${objeto.id}</td>
			<td>${objeto.nome}</td>
			<td><fmt:formatDate value="${objeto.dtCadastro}" pattern="dd/MM/yyyy HH:mm"/></td>
			<td>
				<a href=${linkController}?acao=ActionRemoverObjetos&id=${objeto.id}>Remover </a>
				<a href=${linkController}?acao=ActionExibirObjeto&id=${objeto.id}>| Alterar</a>
				
			</td>
		</tr>
		</c:forEach>	
	</table>
</body>
</html>