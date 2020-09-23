package br.edu.cas.dominio;

public class Usuario implements Comparable<Usuario> {

	private Integer id;
	private String nome;
	private String email;
    private String senha;
    private String telefone;

    public Usuario(String nomeUsuario) {
    	this.setNome(nomeUsuario);
    }

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Usuario:  " 	+ this.getNome()	+
				" E-mail: "		+ this.getEmail()	+
				" Senha: "		+ this.getSenha()	+
				" Telefone: "	+ this.getTelefone();
	}

	@Override
	public boolean equals(Object usuarioCompare) {
		Usuario usuario = (Usuario) usuarioCompare;

		return (this.getId().equals(usuario.getId()));
	}

	@Override
	public int compareTo(Usuario usuarioCompare) {
		return (this.getId() > usuarioCompare.getId()) ? 1 : -1;
	}

}
