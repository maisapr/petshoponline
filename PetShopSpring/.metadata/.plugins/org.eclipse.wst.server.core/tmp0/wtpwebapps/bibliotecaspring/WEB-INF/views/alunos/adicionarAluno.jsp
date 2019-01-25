<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formul�rio adicionar aluno</title>
</head>
<body>
	<c:import url="../Menu.jsp"></c:import>

	<h1>Adicionar aluno</h1>

	<form action="/bibliotecaspring/alunos" method="post">

		<div>

			<label>Matricula: </label>

			<div class="control">

				<input class="input" name="matricula" type="text"
					placeholder="Ex: 20121074010123">
			</div>

		</div>

		<div>

			<label>Nome: </label>
			<div class="control">

				<input class="input" name="nome" type="text" placeholder="Ex: Maria">
			</div>
		</div>


		<div>

			<label>Cpf: </label>
			<div class="control">

				<input class="input" name="cpf" type="text"
					placeholder="Ex: 12345678910">
			</div>

		</div>

		<div>

			<label>Endere�o: </label>
			<div class="control">

				<input class="input" name="endereco" type="text"
					placeholder="Ex: Rua dos bobos">
			</div>

			<div>

				<label>Data de Nascimento: </label>
				<div class="control">

					<input class="input" name="dataNascimento" type="text"
						placeholder="Ex: 01/01/2000">
				</div>
			</div>

			<div>

				<button type="submit">Adicionar</button>
				

			</div>
	</form>

	</div>
</body>
</html>