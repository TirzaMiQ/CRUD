package br.edu.cas.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.cas.dao.UsuarioDAO;
import br.edu.cas.dao.UsuarioDAO;
import br.edu.cas.dominio.Usuario;

@WebServlet("/AlterarUsuario")
public class AlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AlterarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String id = request.getParameter("id");

		Usuario usuario = new Usuario(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTelefone(telefone);
		usuario.setId(Integer.parseInt(id));

		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.alterar(usuario);

		Usuario usuBanco = usuDao.buscarPorId((Integer.parseInt(id)));

		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuBanco);
		session.setAttribute("mensagem", "Usuario " + usuBanco.getNome() + " atualizado!");
		session.setAttribute("status", "color: green;");

		//request.setAttribute("alterarUsuario", new Usuario());


//		RequestDispatcher view = request
//				.getRequestDispatcher("alterarUsuario.jsp");
//		view.forward(request, response);

		response.sendRedirect("home");
	}

}
