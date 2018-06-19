package br.edu.ifsuldeminas.mch.model;

public class Documento {
	
	private String autores ;
	private String dataCadastro;
	private String dataDefesa;
	private String orientador;
	private String co_orientador;
	private String titulo;
	private String sub_titulo;
	private int tipo ;
	private String palavrasChaves;
	private int subArea;
	private String resumo;
	private String caminho;
	
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDataDefesa() {
		return dataDefesa;
	}
	public void setDataDefesa(String dataDefesa) {
		this.dataDefesa = dataDefesa;
	}
	public String getOrientador() {
		return orientador;
	}
	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}
	public String getCo_orientador() {
		return co_orientador;
	}
	public void setCo_orientador(String co_orientador) {
		this.co_orientador = co_orientador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSub_titulo() {
		return sub_titulo;
	}
	public void setSub_titulo(String sub_titulo) {
		this.sub_titulo = sub_titulo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getPalavrasChaves() {
		return palavrasChaves;
	}
	public void setPalavrasChaves(String palavrasChaves) {
		this.palavrasChaves = palavrasChaves;
	}
	public int getSubArea() {
		return subArea;
	}
	public void setSubArea(int subArea) {
		this.subArea = subArea;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	

}
