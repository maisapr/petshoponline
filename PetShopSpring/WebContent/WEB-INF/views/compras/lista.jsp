<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../Menu.jsp"></c:import>

	<h1>Lista de Compras</h1>
	
	<form method="GET" action="/petshoponline/compras/porcliente"> 
		<input type="text" name="nomeDoCliente" placeholder="pesquise pelo nome do cliente..."/>
		<button type="submit">Buscar</button>
	</form>
	

	
		<table border="3">
			<thead>

				<tr>
					<th>ID da Compra</th>
					<th>Nome do Cliente</th>
					<th>Nome do Produto</th>
					<th>Valor</th>
					<th>Data de Compra</th>
				</tr>

					<c:forEach var="compra" items="${compras }">
					<tr>				
						<td>${compra.id }</td>
						<td>${compra.cliente.nome}</td>
						<td>${compra.produto.nome }</td>
						<td>R$: ${compra.valor }</td>
						<td><fmt:formatDate value="${compra.dataCompra.time}" pattern="dd/MM/yyyy"/></td>
						

					</tr>
				</c:forEach>
		</table>


	


</body>
</html>