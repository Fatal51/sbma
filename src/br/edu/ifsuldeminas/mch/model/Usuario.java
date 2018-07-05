package br.edu.ifsuldeminas.mch.model;


public class Usuario  {

	private String login;
	private String senha;
	private boolean bloqueado;
	private boolean Permicao;

	 
	
	public Usuario(String login, String senha) {
		
		this.senha = senha;
		this.login = login;
		
	}
	
	public Usuario(){
		
	}
	

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public boolean validaSenha(String senha) {
		
		if(senha == null)
			return false;
		
		return this.senha.equals(senha);
		
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	 
	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) { 
		this.bloqueado = bloqueado;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAdm() {
		return Permicao;
	}

	public void setAdm(boolean permicao) {
		Permicao = permicao;
	}

	
}
