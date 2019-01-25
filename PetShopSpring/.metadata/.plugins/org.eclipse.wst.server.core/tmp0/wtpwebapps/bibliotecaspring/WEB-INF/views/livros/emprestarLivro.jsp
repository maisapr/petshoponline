<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário adicionar livro</title>
</head>
<body>
	<c:import url="../Menu.jsp"></c:import>

	<h1>Adicionar aluno</h1>

	<form action="/bibliotecaspring/emprestimo" method="post">

		<div>

			<label>Titulo: </label>

			<div class="control">

				<input class="input" name="titulo" type="text"
					placeholder="Ex: Dom Casmurro">
			</div>

		</div>
		<div>

			<label>Matricula do Aluno: </label>
			<div class="control">

				<input class="input" name="matriculaAluno" type="text"
					placeholder="Ex: 20131074010666">
			</div>
			<div>

				<button type="submit">Adicionar</button>

			</div>
	</form>

	</div>
</body>
</html>