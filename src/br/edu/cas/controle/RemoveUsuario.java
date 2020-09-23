package br.edu.cas.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.cas.dao.UsuarioDAO;
import br.edu.cas.dominio.Usuario;

/**
 * Servlet implementation class RemoveUsuario
 */
@WebServlet("/removeUsuario")
public class RemoveUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String id = request.getParameter("id");

    	UsuarioDAO usuarioDAO = new UsuarioDAO();

    	Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));

    	usuarioDAO.excluir(usuario);

    	response.sendRedirect("home");
    }

}
