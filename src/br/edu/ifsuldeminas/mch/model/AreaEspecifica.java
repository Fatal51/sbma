package br.edu.ifsuldeminas.mch.model;

public class AreaEspecifica {
	
	private int codigo;
	private String descricao;
	private SubArea subArea;
	
	public AreaEspecifica() {
		subArea = new SubArea();
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
	public SubArea getSubArea() {
		return subArea;
	}
	public void setSubArea(SubArea subArea) {
		this.subArea = subArea;
	}
	

}
