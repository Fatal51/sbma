package br.edu.ifsuldeminas.mch.model;

public class AreaDoConhecimento {
	
	private int codigo;
	private String descricao;
	private AreaEspecifica areaEspecifica;
	
	public AreaDoConhecimento() {
		areaEspecifica =  new AreaEspecifica();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public AreaEspecifica getAreaEspecifica() {
		return areaEspecifica;
	}
	public void setAreaEspecifica(AreaEspecifica areaEspecifica) {
		this.areaEspecifica = areaEspecifica;
	}
	
}
