///*package br.edu.cas.dao;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import br.edu.cas.dominio.Usuario;
//
//public class Odaozinho implements IDAO{
//
////	private Connection con = Conexao.getConnection();
//
//	public static List<Usuario> listaUsuarios = new ArrayList<>();
//	static Integer idUsuario = 1;
//
//	public Odaozinho() {
//	}
//
//	@Override
//	public void cadastrar(Usuario usuario) {
//
//		String sql = "insert into usuario(nome, email, senha, telefone) values(?, ?, ?, ?)";
//
//		// executando comando sql
//		System.out.println(">> " + sql);
//		System.out.println("Usuario cadastrado: " + usuario.toString());
//		usuario.setId(idUsuario++);
//		listaUsuarios.add(usuario);
//		System.out.println("sucesso");
//
//	}
//
//	// Metodo que faz a alteração / update de um registro.
//	@Override
//	public void alterar(Usuario usuario) {
//		String sql = "update usuario set nome = ?, email = ?, senha = ?, telefone = ? where id_usuario = ?";
//
//		System.out.println(">> " + sql);
//
//		Integer userIdList = listaUsuarios.indexOf(usuario);
//
//		listaUsuarios.set(userIdList, usuario);
//
//	}
//
//	// Metodo responsavel por excluir um registro atraves da chave unica que é o ID.
//	@Override
//	public void excluir(Usuario usuario) {
//		String sql = "delete from usuario where id_usuario = ?";
//
//		listaUsuarios.remove(usuario);
//
//		System.out.println(">> " + sql);
//	}
//
//
//	@Override
//	public Usuario buscarPorId(Integer id) {
//		String sql = "select * from usuario where id_usuario = ?";
//
//		System.out.println(">> " + sql);
//
//		for (Usuario usuario : listaUsuarios) {
//			if(usuario.getId() == id) return usuario;
//		}
//
//		return null;
//	}
//
//	@Override
//	public List<Usuario> buscarTodosOsUsuarios() {
//
//		String sql = "select * from usuario";
//
//		System.out.println(">> " + sql);
//
//		Collections.sort(listaUsuarios);
//
//		return listaUsuarios;
//	}
//
//
//}
*/