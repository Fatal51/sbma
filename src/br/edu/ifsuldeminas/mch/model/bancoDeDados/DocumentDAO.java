package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.model.Documento;

public class DocumentDAO {

	private int numeroRegistros;

	public boolean save(Documento documento) throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("INSERT INTO documentos values " + "(default,?,NOW(),'" + documento.getDataDefesa()
				+ "',?,?,?,?,?,?,?,?,?);");
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

	public boolean update(Documento documento) throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("UPDATE documentos SET autores = ? , orientador = ? , co_orientador = ? ,"
				+ " titulo = ? , sub_titulo = ? , tipo = ? , palavras_chaves = ? ," + " data_defesa = '"
				+ documento.getDataDefesa() + "' , sub_area = ? , resumo = ? , caminho = ? where codigo = ? ; ");

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

	public boolean delete(Documento documento) throws ModelException {
		DBHandler db = new DBHandler();

		db.prepareStatement("DELETE from documentos where codigo = ?");

		db.setInt(1, documento.getCodigo());

		return db.executeUpdate() > 0;
	}

	public List<Documento> documentos(int indice) throws ModelException {

		DBHandler db = new DBHandler();

		this.numeroRegistros = 0;

		db.prepareStatement("SELECT * FROM documentos  LIMIT ? , 16 ;");

		db.setInt(1, indice);

		db.executeQuery();

		List<Documento> lista = new ArrayList<>();

		while (db.next()) {
			numeroRegistros++;
			lista.add(criaDocumento(db));
		}

		return lista;
	}

	public List<Documento> documentosAutor(int indice, String autor) throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("SELECT COUNT(*) as 'registros' FROM documentos where autores LIKE '%" + autor + "%' ;");

		db.executeQuery();
		
		List<Documento> lista = new ArrayList<>();

		if (db.next()) {
			this.numeroRegistros = db.getInt("registros");
			
			db = new DBHandler();

			db.prepareStatement("SELECT * FROM documentos where autores LIKE '%" + autor + "%' LIMIT ? , 15 ;");

			db.setInt(1, indice);

			db.executeQuery();

			while (db.next()) {

				lista.add(criaDocumento(db));
			}

		}

		return lista;
	}

	public List<Documento> documentosTitulo(int indice, String titulo) throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("SELECT * FROM documentos where titulo LIKE '%" + titulo + "%' LIMIT ? , 16 ;");

		db.setInt(1, indice);

		db.executeQuery();

		List<Documento> lista = new ArrayList<>();
		this.numeroRegistros = 0;

		while (db.next()) {

			this.numeroRegistros++;
			lista.add(criaDocumento(db));
		}

		return lista;
	}

	public List<Documento> documentosSubTitulo(int indice, String subTitulo) throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("SELECT * FROM documentos where sub_titulo LIKE '%" + subTitulo + "%' LIMIT ? , 16 ;");

		db.setInt(1, indice);

		db.executeQuery();

		List<Documento> lista = new ArrayList<>();
		this.numeroRegistros = 0;
		while (db.next()) {
			this.numeroRegistros++;
			lista.add(criaDocumento(db));
		}

		return lista;
	}

	public List<Documento> documentosOrientadores(int indice, String orientador, String coOrientador)
			throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("SELECT * FROM documentos where orientador LIKE '%" + orientador
				+ "%' OR co_orientador LIKE '%" + coOrientador + "%'+ LIMIT ? , 16 ;");

		db.setInt(1, indice);

		db.executeQuery();

		List<Documento> lista = new ArrayList<>();
		this.numeroRegistros = 0;

		while (db.next()) {
			this.numeroRegistros++;
			lista.add(criaDocumento(db));
		}

		return lista;
	}

	public List<Documento> buscaAvancada(Documento documento, int indice) throws ModelException {

		String sql = "SELECT * FROM documentos where caminho !=''";

		if (!documento.getAutores().isEmpty()) {
			sql += " AND autores LIKE '%" + documento.getAutores() + "%'";
		}
		if (!documento.getOrientador().isEmpty()) {
			sql += " AND orientador LIKE '%" + documento.getOrientador() + "%'";
		}
		if (!documento.getCo_orientador().isEmpty()) {
			sql += " AND co_orientador LIKE '%" + documento.getCo_orientador() + "%'";
		}
		if (!documento.getTitulo().isEmpty()) {
			sql += " AND titulo LIKE '%" + documento.getTitulo() + "%'";
		}
		if (!documento.getSub_titulo().isEmpty()) {
			sql += " AND sub_titulo LIKE '%" + documento.getSub_titulo() + "%'";
		}
		if (!documento.getPalavrasChaves().isEmpty()) {
			sql += " AND palavras_chaves LIKE '%" + documento.getPalavrasChaves() + "%'";
		}
		if (!documento.getResumo().isEmpty()) {
			sql += " AND resumo LIKE '%" + documento.getResumo() + "%'";
		}
		if (documento.getSubArea() != 0) {
			sql += " AND sub_area = " + documento.getSubArea();
		}
		if (documento.getTipo() != 0) {
			sql += " AND tipo = " + documento.getTipo();
		}
		if (!documento.getDataDefesa().isEmpty()) {
			sql += " AND data_defesa >= " + documento.getDataDefesa();
		}

		sql += " LIMIT ? , 16 ;";

		DBHandler db = new DBHandler();

		db.prepareStatement(sql);
		db.setInt(1, indice);

		db.executeQuery();

		List<Documento> lista = new ArrayList<>();
		this.numeroRegistros = 0;

		while (db.next()) {
			this.numeroRegistros++;
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

	public int getNumeroRegistros() {
		return numeroRegistros;
	}

}