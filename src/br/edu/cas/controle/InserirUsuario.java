package br.edu.cas.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.cas.dao.UsuarioDAO;
import br.edu.cas.dominio.Usuario;

@WebServlet("/InserirUsuario")
public class InserirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InserirUsuario() {
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");

		Usuario usuario = new Usuario(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTelefone(telefone);

		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usuario);

		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);

	}

}
