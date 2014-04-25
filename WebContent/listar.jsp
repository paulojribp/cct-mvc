<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
	<table border="1" style="width: 100%;">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Preço</th>
			</tr>
		</thead>
		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td>${produto.id }</td>
				<td>${produto.nome }</td>
				<td>${produto.preco }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>