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
		db.setString(3, documento.getCoOrientador());
		db.setString(4, documento.getTitulo());
		db.setString(5, documento.getSubTitulo());
		db.setInt(6, documento.getTipo());
		db.setString(7, documento.getPalavrasChaves());
		db.setInt(8, documento.getGrandeArea().getArea().getAreaEspecifica().getSubArea().getCodigo());
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
		db.setString(3, documento.getCoOrientador());
		db.setString(4, documento.getTitulo());
		db.setString(5, documento.getSubTitulo());
		db.setInt(6, documento.getTipo());
		db.setString(7, documento.getPalavrasChaves());
		db.setInt(8, documento.getGrandeArea().getArea().getAreaEspecifica().getSubArea().getCodigo());
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

		db.prepareStatement("SELECT * FROM documentos  LIMIT ? , 15 ;");

		db.setInt(1, indice);

		db.executeQuery();

		List<Documento> lista = new ArrayList<>();

		while (db.next()) {
			numeroRegistros++;
			lista.add(criaDocumento(db));
		}

		return lista;
	}
	
	public Documento documento(int codigo) throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("SELECT * FROM documentos  where  codigo = ?;");

		db.setInt(1, codigo);

		db.executeQuery();

		if (db.next()) {
		
			return criaDocumento(db);
		}

		return new Documento();
	}

	public List<Documento> documentosAutor(int indice, String autor) throws ModelException {

		DBHandler db = new DBHandler();

		
		db.prepareStatement("SELECT COUNT(*) as 'registros' FROM documentos where autores LIKE '" + formataAutoresBusca(autor) + "' ;");

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

		db.prepareStatement("SELECT COUNT(*) as 'registros' FROM documentos where titulo LIKE '%" + titulo + "%'  ;");

		db.executeQuery();
		

		List<Documento> lista = new ArrayList<>();
		this.numeroRegistros = 0;

		if (db.next()) {
			
			this.numeroRegistros = db.getInt("registros");
			
			 db = new DBHandler();

			db.prepareStatement("SELECT * FROM documentos where titulo LIKE '%" + titulo + "%' LIMIT ? , 15 ;");

			db.setInt(1, indice);

			db.executeQuery();

			while(db.next())
			lista.add(criaDocumento(db));
		}

		return lista;
	}

	public List<Documento> documentosSubTitulo(int indice, String subTitulo) throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("SELECT COUNT(*) as 'registros' FROM documentos where sub_titulo LIKE '%" + subTitulo + "%' ;");

		db.executeQuery();
		

		List<Documento> lista = new ArrayList<>();
		this.numeroRegistros = 0;

		if (db.next()) {
			
			this.numeroRegistros = db.getInt("registros");
			
			 db = new DBHandler();

			db.prepareStatement("SELECT * FROM documentos where sub_titulo LIKE '%" + subTitulo + "%' LIMIT ? , 16 ;");

			db.setInt(1, indice);

			db.executeQuery();

			while(db.next())
			lista.add(criaDocumento(db));
		}

		return lista;


	}

	public List<Documento> documentosOrientadores(int indice, String orientador)
			throws ModelException {

		DBHandler db = new DBHandler();

		db.prepareStatement("SELECT COUNT(*) as 'registros' FROM documentos where orientador LIKE '%" + orientador + 
				"%' OR co_orientador LIKE '%" + orientador + "%';");

		db.executeQuery();
		

		List<Documento> lista = new ArrayList<>();
		this.numeroRegistros = 0;

		if (db.next()) {
			
			this.numeroRegistros = db.getInt("registros");
			
			 db = new DBHandler();

			db.prepareStatement("SELECT * FROM documentos where orientador LIKE '%" + orientador + 
					"%' OR co_orientador LIKE '%" + orientador + "%' LIMIT ? , 15 ;");

			db.setInt(1, indice);

			db.executeQuery();

			while(db.next())
			lista.add(criaDocumento(db));
		}

		return lista;

		
	}

	public List<Documento> buscaAvancada(Documento documento, int indice) throws ModelException {

		String sql1= "SELECT COUNT(*) as 'registros' FROM documentos where caminho !='' ";
		String sql2 ="";

		if (!documento.getAutores().isEmpty()) {
			sql2 += " AND autores LIKE '" + formataAutoresBusca(documento.getAutores())  + "'";
		}
		if (!documento.getOrientador().isEmpty()) {
			sql2 += " AND orientador LIKE '%" + documento.getOrientador() + "%'";
		}
		if (!documento.getCoOrientador().isEmpty()) {
			sql2 += " AND co_orientador LIKE '%" + documento.getCoOrientador() + "%'";
		}
		if (!documento.getTitulo().isEmpty()) {
			sql2 += " AND titulo LIKE '%" + documento.getTitulo() + "%'";
		}
		if (!documento.getSubTitulo().isEmpty()) {
			sql2 += " AND sub_titulo LIKE '%" + documento.getSubTitulo() + "%'";
		}
		if (!documento.getPalavrasChaves().isEmpty()) {
			sql2 += " AND palavras_chaves LIKE '%" + documento.getPalavrasChaves() + "%'";
		}
		if (!documento.getResumo().isEmpty()) {
			sql2 += " AND resumo LIKE '%" + documento.getResumo() + "%'";
		}
		if (documento.getGrandeArea().getArea().getAreaEspecifica().getSubArea().getCodigo() != 0) {
			sql2 += " AND sub_area = " + documento.getGrandeArea().getArea().getAreaEspecifica().getSubArea().getCodigo();
		}
		if (documento.getTipo() != 0) {
			sql2 += " AND tipo = " + documento.getTipo();
		}
		if (!documento.getDataDefesa().isEmpty()) {
			sql2 += " AND data_defesa >= " + documento.getDataDefesa();
		}

		String sql3 = " LIMIT ? , 15 ;";

		DBHandler db = new DBHandler();

		db.prepareStatement(sql1+sql2+" ;");

		db.executeQuery();
		

		List<Documento> lista = new ArrayList<>();
		this.numeroRegistros = 0;

		if (db.next()) {
			
			this.numeroRegistros = db.getInt("registros");
			
			 db = new DBHandler();

			db.prepareStatement("SELECT * FROM documentos where caminho !='' "+sql2+sql3);

			db.setInt(1, indice);

			db.executeQuery();

			while(db.next())
			lista.add(criaDocumento(db));
		}

		return lista;

		
	}

	private Documento criaDocumento(DBHandler db) throws ModelException {

		Documento doc = new Documento();
		
		GrandeAreaDAO gaDAO = new GrandeAreaDAO();
		
		doc.setAutores(db.getString("autores"));
		doc.setCaminho(db.getString("caminho"));
		doc.setCoOrientador(db.getString("co_orientador"));
		doc.setDataCadastro(db.getString("data_cadastro"));
		doc.setDataDefesa(db.getString("data_defesa"));
		doc.setOrientador(db.getString("orientador"));
		doc.setPalavrasChaves(db.getString("palavras_chaves"));
		doc.setResumo(db.getString("resumo"));
		doc.setSubTitulo(db.getString("sub_titulo"));
		doc.setGrandeArea(gaDAO.findAreas(db.getInt("sub_area")));
		doc.setTipo(db.getInt("tipo"));
		doc.setTitulo(db.getString("titulo"));
		doc.setCodigo(db.getInt("codigo"));

		return doc;
	}
	
	private String formataAutoresBusca(String autor) {
		String[] autores = autor.split(";");
		String consulta="";
		
		for(String a : autores) {
			
			consulta+="%"+a+"%";	
		}
		
		return consulta;
	}

	public int getNumeroRegistros() {
		return numeroRegistros;
	}

}