package br.edu.ifsuldeminas.mch.model;

public class GrandeArea {
	
	private int codigo;
	private String descricao;
	private AreaDoConhecimento area;
	
	
	public GrandeArea() {
		area = new AreaDoConhecimento();
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
	public AreaDoConhecimento getArea() {
		return area;
	}
	public void setArea(AreaDoConhecimento area) {
		this.area = area;
	}
	
	
}
