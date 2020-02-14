package br.com.alura.gerenciador.model;

public class Usuario {

	private int id;
	private String login;
	private String senha;
	private static int seqId = 90000;
	
	public Usuario(String login, String senha){
		
		Usuario.seqId++;
		this.login = login;
		this.senha = senha;
		this.id = seqId;
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean ehIgual(String login, String senha) {
		if(!this.login.equals(login)) {
			return false;
		}
		
		if(!this.senha.equals(senha)) {
			return false;
		}
		
		return true;
	}

	public int getId() {
		return id;
	}
}
