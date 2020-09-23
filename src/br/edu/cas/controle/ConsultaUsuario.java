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

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/consultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConsultaUsuario() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));

		request.setAttribute("usuario", usuario);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("alterarUsuario.jsp");
		requestDispatcher.forward(request, response);
	}

}
