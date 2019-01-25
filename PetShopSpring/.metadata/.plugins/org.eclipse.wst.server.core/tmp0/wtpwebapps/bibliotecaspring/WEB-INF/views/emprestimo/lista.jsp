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

	<h1>Lista de emprestimos</h1>
	

	
		<table border="3">
			<thead>

				<tr>
					<th>Aluno</th>
					<th>Matr�cula do Aluno</th>
					<th>Livro</th>
					<th>Data de Emprestimo</th>
					<th>Data de Devolu��o</th>
				</tr>

					<c:forEach var="emprestimo" items="${emprestimos }">
					<tr>				
						<td>${emprestimo.aluno.nome }</td>
						<td>${emprestimo.aluno.matricula }</td>
						<td>${emprestimo.livro.titulo }</td>
						<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}"
									pattern="dd/MM/yyyy" /></td>
						<c:if test="${empty emprestimo.dataDevolucao}">
							<td>
								<form method="POST" action="/bibliotecaspring/emprestimo/devolucao"> 
									<input type="hidden" name="idAluno" value="${emprestimo.aluno.id}"/>
									<input type="hidden" name="idLivro" value="${emprestimo.livro.id}"/>
									<button type="submit">Fazer Devolu��o</button>
								</form>
							</td>
						</c:if>
						<c:if test="${not empty emprestimo.dataDevolucao}">
							<td><fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy" /></td>
						</c:if>

					</tr>
				</c:forEach>
		</table>


	


</body>
</html>