package br.edu.cas.dao;

import java.util.List;

import br.edu.cas.dominio.Usuario;

public interface IDAO {

	void cadastrar(Usuario usuario);

	void alterar(Usuario usuario);

	void excluir(Usuario usuario);

	Usuario buscarPorId(Integer id);

	public List<Usuario> buscarTodosOsUsuarios();





}
