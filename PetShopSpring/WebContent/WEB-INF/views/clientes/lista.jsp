<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes - Cliente de Clientes</title>
</head>
<body>
	<c:import url="../Menu.jsp"></c:import>

	<h1>Lista de clientes</h1>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Cpf</th>
			<th>Endereco</th>
			<th>Data De Nascimento</th>
		</tr>
		<c:forEach var="cliente" items="${clientes}">
			<tr>
				<td>${cliente.id}</td>
				<td>${cliente.nome }</td>
				<td>${cliente.cpf }</td>
				<td>${cliente.endereco }</td>
				<td><fmt:formatDate value="${cliente.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>