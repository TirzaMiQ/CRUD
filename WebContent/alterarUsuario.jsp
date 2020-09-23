<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
function home() {
  location.replace("index.jsp")
}
</script>

<title>Alterar Usuário</title>
</head>
<body style="background-color: #EEEEEE">

	<nav>
		<div class="nav-wrapper">
			<p class="brand-logo logo">Cadastro de Usuários</p>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="index.jsp">Início</a></li>
			</ul>
		</div>
	</nav>

	<h3>Alterar Usuário</h3>
	<div class="content">
			<form action="AlterarUsuario" method="post">
			<input type="hidden" name="id" value="${usuario.id}">
			<%-- <c:out value="${usuario.id}"> --%>
				<div class="form-group col-md-6 espacamento">
					<label for="nome">Nome</label> <input type="text" name="nome"
						value="${usuario.nome}">
				</div>

				<div class="form-group col-md-6 espacamento">
					<label for="nome">Email</label> <input type="email" name="email"
						value="${usuario.email}">
				</div>

				<div class="form-group col-md-6 espacamento">
					<label for="nome">Senha</label> <input type="text" name="senha"
						value="${usuario.senha}">
				</div>

				<div class="form-group col-md-6 espacamento">
					<label for="telefone">Telefone</label> <input type="text"
						name="telefone" value="${usuario.telefone}">
				</div>
			<%-- </c:out> --%>

				<br>
				<br>
				<button type="submit" class="btn btn-success" id="operacao"
					name="operacao" value="AlterarUsuario">Alterar</button>

				<button type="reset" class="btn ml-2" value="Voltar"
					onclick="home()">Voltar</button>

		</form>
	</div>

</body>
</html>