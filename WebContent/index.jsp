<%@page import="br.edu.cas.dao.UsuarioDAO"%>
<%@page import="br.edu.cas.dominio.Usuario"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<script>
function confirmaRemocao(id, nome){

	var confirma = window.confirm("Deseja remover o usuário: " + nome + "?");

	if (confirma) {

        let remocao = window.location.href = "removeUsuario?id=" + id;

    }
}
</script>


<link rel="stylesheet" href="css/style.css">


<title>Cadastro</title>
</head>

<body style="background-color: #EEEEEE">

	<nav class="navbas navbar-fixed-top">
		<div class="nav-wrapper">
			<p class="brand-logo logo">Cadastro de Usuários</p>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li>Início</li>
				<li><a href="alterarUsuario.jsp">Atualizar Usuário</a></li>
			</ul>
		</div>
	</nav>

	<div id="main" class="container-fluid" style="margin-top: 50px">
		<div class="margin">
			<form action="InserirUsuario" method="POST">
				<div id="corpo" class="form-group container">
					<div class="form-group col-md-6 espacamento">
						<input type="text" name="nome" class="form-control"
							placeholder="Nome" required>
					</div>

					<div class="form-group col-md-6 espacamento">
						<input type="email" name="email" class="form-control"
							placeholder="Email">
					</div>

					<div class="form-group col-md-6 espacamento">
						<input type="password" name="senha" class="form-control"
							placeholder="Senha">
					</div>

					<div class="form-group col-md-6 espacamento">
						<input type="text" name="telefone" class="form-control"
							placeholder="Telefone">
					</div>
					<br> <br>

					<div id="botao" class="form-group container">
						<button type="submit" class="btn btn-success space" id="operacao"
							name="operacao" value="SALVAR">Cadastrar</button>

						<button type="reset" class="btn btn-warning" value="limpar">Limpar</button>
					</div>
				</div>
			</form>
		</div>
	</div>


	<%
		UsuarioDAO uDAO = new UsuarioDAO();
		List<Usuario> usuarios = uDAO.buscarTodosOsUsuarios();
	%>

	<div class="container-fluid margin" style="margin-top: 100px">
		<table class="table table-dark" style="background-color: black;">
			<thead>
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">Email</th>
					<th scope="col">Senha</th>
					<th scope="col">Telefone</th>
					<th scope="col">Ações</th>
				</tr>
			<thead>

				<%
					for (int i = 0; i < usuarios.size(); i++) {
						Usuario usuario = usuarios.get(i);
				%>

			<tbody>
				<tr>

					<td scope="row"><%=usuario.getNome()%></td>
					<td><%=usuario.getEmail()%></td>
					<td><%=usuario.getSenha()%></td>
					<td><%=usuario.getTelefone()%></td>
					<td>
						<a href="consultaUsuario?id=<%=usuario.getId()%>">Alterar</a> |
						<a href="javascript:confirmaRemocao(<%=usuario.getId()%>, '<%=usuario.getNome()%>')">Remover</a>
					</td>
				</tr>
			</tbody>

			<%
				}
			%>

		</table>
	</div>
</body>
</html>