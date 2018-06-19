package br.edu.ifsuldeminas.mch.model.bancoDeDados;
import java.util.List;

import br.edu.ifsuldeminas.mch.model.Documento;

public class DocumentDAO {


	public boolean save(Documento documento) {
		
		
		try {
			
			DBHandler db = new DBHandler();
			
			db.prepareStatement("INSERT INTO documentos values "
					+ "(default,?,NOW(),"+documento.getDataDefesa()+",?,?,?,?,?,?,?,?,?);");
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
			
			
			
			
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}


}
