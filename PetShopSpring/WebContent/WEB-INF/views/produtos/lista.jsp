<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Produtos</title>
</head>
<body>

	<c:import url="../Menu.jsp"></c:import>



	<h1>Lista de Produtos</h1>
	<form method="GET" action="/petshoponline/produtos/pormarca"> 
		<input type="text" name="marca" placeholder="pesquise pela marca do produto..."/>
		<button type="submit">Buscar</button>
	</form>

	<table border="3">
		<thead>

			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Marca</th>
				<th>Categoria</th>
				<th>Preco</th>
				<th>Data de Validade</th>
				<th>Realizar Compra</th>
			</tr>
			<c:forEach var="produto" items="${produtos}">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.nome }</td>
				<td>${produto.marca }</td>
				<td>${produto.categoria }</td>
				<td>R$: ${produto.preco }</td>
				<td><fmt:formatDate value="${produto.dataValidade.time}"
						pattern="dd/MM/yyyy" /></td>
				<td>
					<form method="POST" action="/petshoponline/compras/adicionar"> 
						<input type="hidden" name="idDoProduto" value="${produto.id}"/>
						<button type="submit">Comprar!</button>
					</form>
				</td>
	
			</tr>
		</c:forEach>
			
	</table>
</body>
</html>
