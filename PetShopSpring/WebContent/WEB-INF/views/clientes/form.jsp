<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home - Cliente de Clientes</title>
</head>
<body>
	<c:import url="../Menu.jsp"></c:import>
	<h1>Adicionando um Cliente:</h1>
	<form action="/petshoponline/clientes/" method="post">
		<div>
			<label>Nome: </label> <input type="text" name="nome" />
		</div>
		<div>
			<label>Cpf: </label> <input type="text" name="cpf" />
		</div>
		<div>
			<label>Endereco: </label> <input type="text" name="endereco" />
		</div>
		<div>
			<label>Data Nascimento: </label> <input type="text"
				name="dataNascimento" />
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
</body>
</html>