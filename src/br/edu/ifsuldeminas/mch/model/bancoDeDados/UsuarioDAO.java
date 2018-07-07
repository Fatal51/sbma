package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import br.edu.ifsuldeminas.mch.model.Usuario;

public class UsuarioDAO {
	
	public boolean validaUsuario(Usuario u) throws ModelException{
		
		
	String sql = "SELECT * FROM usuarios WHERE email = ? ; ";
	
	DBHandler db = new DBHandler();
	
	db.prepareStatement(sql);
	
	db.setString(1,u.getLogin());
		
	db.executeQuery();
	
	if(db.next()){
		
		if(u.getSenha().equals(db.getString("senha"))){
			u.setBloqueado(db.getBoolean("ativo"));
			u.setAdm(db.getBoolean("tipo"));
			
			db.close();
			return true;
		}
		
	}
		
		return false;
		
	}

	
	public boolean save(Usuario u) throws ModelException {
			
		DBHandler db = new DBHandler();
		
		db.prepareStatement("insert into usuarios values (?,?,?,?) ; ");
		
		db.setString(1,u.getSenha());
		db.setBoolean(2, u.isAdm());
		db.setBoolean(3, !u.isBloqueado());
		db.setString(4, u.getLogin());
			
	return	db.executeUpdate() > 0;
	
	}

	
	public boolean delete(Usuario u) throws ModelException {
	
		
		DBHandler db = new DBHandler();
		
		db.prepareStatement("delete from usuarios where login = ? ; ");
	
		db.setString(1, u.getLogin());
			
	return	db.executeUpdate() > 0;
	}

	
	public boolean alter(Usuario u) throws ModelException {
		
	
		
		DBHandler db = new DBHandler();
		
		db.prepareStatement("update usuarios set senha = ? where login = ? ; ");
		
	
		db.setString(1,u.getSenha());
		db.setString(2, u.getLogin());
			
	return	db.executeUpdate() > 0;
		
		
		
	}

	public boolean confirmaCadastro(Usuario u) throws ModelException {
		
	
		
		DBHandler db = new DBHandler();
		
		db.prepareStatement("update usuarios set ativo = true where email = ? ; ");
		

		db.setString(1, u.getLogin());
			
	return	db.executeUpdate() > 0;
		
		
		
	}


}
