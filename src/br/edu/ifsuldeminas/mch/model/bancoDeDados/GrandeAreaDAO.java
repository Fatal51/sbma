package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.model.AreaDoConhecimento;
import br.edu.ifsuldeminas.mch.model.AreaEspecifica;
import br.edu.ifsuldeminas.mch.model.GrandeArea;
import br.edu.ifsuldeminas.mch.model.SubArea;

public class GrandeAreaDAO {

	public GrandeArea findAreas(int int1) throws ModelException {
		
		DBHandler db = new DBHandler();

		db.prepareStatement("select ga.codigo as 'gacodigo',ga.descricao as 'gadescricao',ac.codigo  as 'accodigo'," + 
				"				ac.descricao  as 'acdescricao',ae.codigo  as 'aecodigo'," + 
				"ae.descricao as 'aedescricao',sa.codigo as 'sacodigo',sa.descricao as 'sadescricao' from grande_area as ga" + 
				"				inner join area_conhecimento as ac on ga.codigo = ac.ga" + 
				"				inner join area_especifica as ae on ac.codigo = ae.ac" + 
				"				inner join sub_area as sa on sa.ae = ae.codigo where sa.codigo = ? ;");

		db.setInt(1, int1);
		db.executeQuery();
		

		if (db.next()) {
			
			return criaGrandeAreaCompleta(db);
		}


		return null;
	}
	
	public List<GrandeArea> grandeAreaList() throws ModelException{
		
		
		
		DBHandler db = new DBHandler();

		db.prepareStatement("select * from grande_area ;");

		db.executeQuery();
		
		List<GrandeArea> lista = new ArrayList<>();

		while(db.next()) {
			
		lista.add(criaGrandeArea(db));
		}

		
		return lista;
	}
	
	public List<AreaDoConhecimento> areaConhecimentoList(int idga) throws ModelException{
		
		
		
		DBHandler db = new DBHandler();

		db.prepareStatement("select * from area_conhecimento where ga = ? ;");

		db.setInt(1, idga);
		
		db.executeQuery();
		
		List<AreaDoConhecimento> lista = new ArrayList<>();

		while(db.next()) {
			
		lista.add(criaAreaC(db));
		}

		
		return lista;
	}
	
	
	public List<AreaEspecifica> areaEspecificaList(int idac) throws ModelException{
		
		
		
		DBHandler db = new DBHandler();

		db.prepareStatement("select * from area_especifica where ac = ? ;");

		db.setInt(1, idac);
		
		db.executeQuery();
		
		List<AreaEspecifica> lista = new ArrayList<>();

		while(db.next()) {
			
		lista.add(criaAreaE(db));
		}

		
		return lista;
	}
	
	
	public List<SubArea> subAreaList(int idae) throws ModelException{
		
		
		
		DBHandler db = new DBHandler();

		db.prepareStatement("select * from sub_area where ae = ? ;");

		db.setInt(1, idae);
		
		db.executeQuery();
		
		List<SubArea> lista = new ArrayList<>();

		while(db.next()) {
			
		lista.add(criaSubE(db));
		}

		
		return lista;
	}
	
	private GrandeArea criaGrandeArea(DBHandler db) throws ModelException {
		
		GrandeArea g = new GrandeArea();
		g.setCodigo(db.getInt("codigo"));
		g.setDescricao(db.getString("descricao"));
		
		return g;
		
	}

	private AreaDoConhecimento criaAreaC(DBHandler db) throws ModelException {
		
		AreaDoConhecimento g = new AreaDoConhecimento();
		g.setCodigo(db.getInt("codigo"));
		g.setDescricao(db.getString("descricao"));
		
		return g;
		
	}
	
	private AreaEspecifica criaAreaE(DBHandler db) throws ModelException {
		
		AreaEspecifica g = new AreaEspecifica();
		g.setCodigo(db.getInt("codigo"));
		g.setDescricao(db.getString("descricao"));
		
		return g;
		
	}
	
	private SubArea criaSubE(DBHandler db) throws ModelException {
		
		SubArea g = new SubArea();
		g.setCodigo(db.getInt("codigo"));
		g.setDescricao(db.getString("descricao"));
		
		return g;
		
	}
	
	
	private GrandeArea criaGrandeAreaCompleta(DBHandler db) throws ModelException {

		GrandeArea ga = new GrandeArea();
		ga.setCodigo(db.getInt("gacodigo"));
		ga.setDescricao(db.getString("gadescricao"));
		ga.getArea().setCodigo(db.getInt("accodigo"));
		ga.getArea().setDescricao(db.getString("acdescricao"));
		ga.getArea().getAreaEspecifica().setCodigo(db.getInt("aecodigo"));
		ga.getArea().getAreaEspecifica().setDescricao(db.getString("aedescricao"));
		ga.getArea().getAreaEspecifica().getSubArea().setCodigo(db.getInt("sacodigo"));
		ga.getArea().getAreaEspecifica().getSubArea().setDescricao(db.getString("sadescricao"));
		
		return ga;
	}
	
 
}
