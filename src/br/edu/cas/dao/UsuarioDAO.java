package br.edu.cas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.cas.dominio.Usuario;
import br.edu.cas.util.Conexao;

public class UsuarioDAO implements IDAO{

	private Connection con = Conexao.getConnection();

	public UsuarioDAO() {
	}

	@Override
	public void cadastrar(Usuario usuario) {

		String sql = "insert into usuario(nome, email, senha, telefone) values(?, ?, ?, ?)";

		try {

			PreparedStatement preparestatement = con.prepareStatement(sql);

			preparestatement.setString(1, usuario.getNome());
			preparestatement.setString(2, usuario.getEmail());
			preparestatement.setString(3, usuario.getSenha());
			preparestatement.setString(4, usuario.getTelefone());

			// executando comando sql
			preparestatement.execute();
			System.out.println("sucesso");

			// preparestatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Metodo que faz a alteração / update de um registro.
	@Override
	public void alterar(Usuario usuario) {
		String sql = "update usuario set nome = ?, email = ?, senha = ?, telefone = ? where id_usuario = ?";

		try {

			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setString(4, usuario.getTelefone());
			preparedStatement.setInt(5, usuario.getId());

			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Metodo responsavel por excluir um registro atraves da chave unica que é o ID.
	@Override
	public void excluir(Usuario usuario) {
		String sql = "delete from usuario where id_usuario = ?";

		try {

			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setInt(1, usuario.getId());

			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que salva o usuário no banco de dados. Caso o usuario ja exista
	 * e for diferente de null, entende-se que é para fazer uma alteração. Ou caso o
	 * usuario passado nao exista na base de dados ele salva como um novo.
	 *
	 * @param usuario objeto que sera salvo na base de dados.
	 */
	/*
	 * public void salvar(Usuario usuario){ if(usuario.getId() != null &&
	 * usuario.getId()!=0 ){ alterar(usuario); }else { cadastrar(usuario); } }
	 */

	@Override
	public Usuario buscarPorId(Integer id) {
		String sql = "select * from usuario where id_usuario = ?";
		Usuario usuario = null;

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				usuario = new Usuario(result.getString("nome"));
				usuario.setEmail(result.getString("email"));
				usuario.setSenha(result.getString("senha"));
				usuario.setTelefone(result.getString("telefone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public List<Usuario> buscarTodosOsUsuarios() {
		List<Usuario> listarUsuarios = new ArrayList<>();

		String sql = "select * from usuario";
		Usuario usuarios = null;

		try {

        	PreparedStatement preparedStatement = con.prepareStatement(sql);

			ResultSet result = preparedStatement.executeQuery();

			// verifica se tem registro no banco de dados, enquanto tiver registro vai
			// adcionando um a um nessa lista e depois retorna todos os registros que foram
			// encontrados na busca.
			while (result.next()) {
				usuarios = new Usuario(result.getString("nome"));
				usuarios.setEmail(result.getString("email"));
				usuarios.setSenha(result.getString("senha"));
				usuarios.setTelefone(result.getString("telefone"));

				// Adcionando cada registro que foi achado na lista para ser exibida.
				listarUsuarios.add(usuarios);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listarUsuarios;
	}


}
