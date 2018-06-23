package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import java.util.List;

import br.edu.ifsuldeminas.mch.model.Usuario;
import br.edu.ifsuldeminas.mch.model.interfaces.ObjectDAO;

public class UsuarioDAO implements ObjectDAO<Usuario> {
	
	public boolean validaUsuario(Usuario u) throws ModelException{
		
		
	String sql = "SELECT * FROM usuarios WHERE email = ? ; ";
	
	DBHandler db = new DBHandler();
	
	db.prepareStatement(sql);
	
	db.setString(1,u.getLogin());
		
	db.executeQuery();
	
	if(db.next()){
		
		if(u.getSenha().equals(db.getString("senha"))){
			u.setBloqueado(db.getBoolean("ativo"));
			u.setAdm(db.getBoolean("administrador"));
			u.setDescricao(db.getString("descricao"));
	
			return true;
		}
		
	}
		
		return false;
		
	}

	@Override
	public boolean save(Usuario objeto) {
		
		
		return false;
	}

	@Override
	public boolean delete(Usuario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alter(Usuario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
