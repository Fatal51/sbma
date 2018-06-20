package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.model.Documento;

public class DocumentDAO {


	public boolean save(Documento documento) throws ModelException {
		
		
		DBHandler db = new DBHandler();
		
		db.prepareStatement("INSERT INTO documentos values "
				+ "(default,?,NOW(),'"+documento.getDataDefesa()+"',?,?,?,?,?,?,?,?,?);");
		db.setString(1, documento.getAutores());
		db.setString(2, documento.getOrientador());
		db.setString(3, documento.getCo_orientador());
		db.setString(4, documento.getTitulo());
		db.setString(5, documento.getSub_titulo());
		db.setInt(6, documento.getTipo());
		db.setString(7, documento.getPalavrasChaves());
		db.setInt(8, documento.getSubArea());
		db.setString(9, documento.getResumo());
		db.setString(10, documento.getCaminho());
		
		return db.executeUpdate() > 0;

}

public boolean update(Documento documento) throws ModelException{
	
	
	DBHandler db = new DBHandler();
	
	db.prepareStatement("UPDATE documentos SET autores = ? , orientador = ? , co_orientador = ? ,"
					  + " titulo = ? , sub_titulo = ? , tipo = ? , palavras_chaves = ? ,"
					  + " data_defesa = '"+documento.getDataDefesa()+"' , sub_area = ? , resumo = ? , caminho = ? where codigo = ? ; ");
	
	db.setString(1, documento.getAutores());
	db.setString(2, documento.getOrientador());
	db.setString(3, documento.getCo_orientador());
	db.setString(4, documento.getTitulo());
	db.setString(5, documento.getSub_titulo());
	db.setInt(6, documento.getTipo());
	db.setString(7, documento.getPalavrasChaves());
	db.setInt(8, documento.getSubArea());
	db.setString(9, documento.getResumo());
	db.setString(10, documento.getCaminho());
	db.setInt(11, documento.getCodigo());
	
	
	return db.executeUpdate() > 0;
}

public boolean delete(Documento documento) throws ModelException{
	DBHandler db = new DBHandler();
	
	db.prepareStatement("DELETE from documentos where codigo = ?");
	
	db.setInt(1, documento.getCodigo());
	
	return db.executeUpdate()>0;
}

public List<Documento> documentos(int indice) throws ModelException {
	
	DBHandler db = new DBHandler();
	
	db.prepareStatement("SELECT * FROM documentos  LIMIT ? , 16 ;");
	
	db.setInt(1, indice);
	
	db.executeQuery();
	
	List<Documento> lista = new ArrayList<>();
	
	while(db.next()) {
		
		lista.add(criaDocumento(db));
	}
	
	return lista;
}

public List<Documento> documentosAutor(int indice,String autor) throws ModelException {
	
	DBHandler db = new DBHandler();
	
	db.prepareStatement("SELECT * FROM documentos where autores LIKE '%"+
	autor+"%' LIMIT ? , 16 ;");

	db.setInt(1, indice);
	
	db.executeQuery();
	
	List<Documento> lista = new ArrayList<>();
	
	while(db.next()) {
		
		lista.add(criaDocumento(db));
	}
	
	return lista;
}

public List<Documento> documentosTitulo(int indice,String titulo) throws ModelException {
	
	DBHandler db = new DBHandler();
	
	db.prepareStatement("SELECT * FROM documentos where titulo LIKE '%"+
	titulo+"%' LIMIT ? , 16 ;");

	db.setInt(1, indice);
	
	db.executeQuery();
	
	List<Documento> lista = new ArrayList<>();
	
	while(db.next()) {
		
		lista.add(criaDocumento(db));
	}
	
	return lista;
}

public List<Documento> documentosSubTitulo(int indice,String subTitulo) throws ModelException {
	
	DBHandler db = new DBHandler();
	
	db.prepareStatement("SELECT * FROM documentos where sub_titulo LIKE '%"+
	subTitulo+"%' LIMIT ? , 16 ;");

	db.setInt(1, indice);
	
	db.executeQuery();
	
	List<Documento> lista = new ArrayList<>();
	
	while(db.next()) {
		
		lista.add(criaDocumento(db));
	}
	
	return lista;
}

public List<Documento> documentosOrientadores(int indice,String orientador,String coOrientador) throws ModelException {
	
	DBHandler db = new DBHandler();
	
	db.prepareStatement("SELECT * FROM documentos where orientador LIKE '%"+
	orientador+"%' OR co_orientador LIKE '%" + coOrientador  
			+"%'+ LIMIT ? , 16 ;");

	db.setInt(1, indice);
	
	db.executeQuery();
	
	List<Documento> lista = new ArrayList<>();
	
	while(db.next()) {
		
		lista.add(criaDocumento(db));
	}
	
	return lista;
}


private Documento criaDocumento(DBHandler db) throws ModelException {
	
	Documento doc = new Documento();
	
	doc.setAutores(db.getString("autores"));
	doc.setCaminho(db.getString("caminho"));
	doc.setCo_orientador(db.getString("co_orientador"));
	doc.setDataCadastro(db.getString("data_cadastro"));
	doc.setDataDefesa(db.getString("data_defesa"));
	doc.setOrientador(db.getString("orientador"));
	doc.setPalavrasChaves(db.getString("palavras_chaves"));
	doc.setResumo(db.getString("resumo"));
	doc.setSub_titulo(db.getString("sub_titulo"));
	doc.setSubArea(db.getInt("sub_area"));
	doc.setTipo(db.getInt("tipo"));
	doc.setTitulo(db.getString("titulo"));
	doc.setCodigo(db.getInt("codigo"));
	
	return doc;
}

}