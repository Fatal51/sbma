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
	private int codigo;
	
	public String referencia() {
		
		String[] autores = this.autores.split(";");
		
		String referencia ="";
		
		if(autores.length>1) {
			
			for(String a : autores)
				referencia+=formataAutor(a)+";";
			
		}else
			referencia+=formataAutor(autores[0])+".";
			
		
		return referencia+=" "+dataDefesa.split("-")[1]+"/"+dataDefesa.split("-")[0];
		
	}
	
	private String formataAutor(String autor) {
		String formatado = "";
		
		String[] nomes =  autor.split(" ");
		
		formatado+=nomes[nomes.length-1].toUpperCase()+",";
		
		for(int a=0; a < nomes.length - 1 ;a++) {
			if(!nomes[a].equalsIgnoreCase(""))
				formatado+=nomes[a].toUpperCase().substring(0, 1)+".";
		}
		
		return formatado;
		
	}
	
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
	public String getCoOrientador() {
		return co_orientador;
	}
	public void setCoOrientador(String co_orientador) {
		this.co_orientador = co_orientador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubTitulo() {
		return sub_titulo;
	}
	public void setSubTitulo(String sub_titulo) {
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String dataSerta() {
		return reverse(dataDefesa);
	}
	private  String reverse (String o) {

	    String[] pedacos = o.split("-");
    
	   return pedacos[2]+"/"+pedacos[1]+"/"+pedacos[0];
	}
}
