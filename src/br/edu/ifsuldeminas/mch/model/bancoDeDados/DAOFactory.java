package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifsuldeminas.mch.model.Usuario;
import br.edu.ifsuldeminas.mch.model.bancoDeDados.dao.UsuarioDAO;

public class DAOFactory {
	
	private static Map<Class, Object> listDAOsInterfaces = new HashMap<Class, Object>();
	
	
	static {
		
		listDAOsInterfaces.put(Usuario.class, new UsuarioDAO());
	
			
	}
	
	@SuppressWarnings("unchecked")
	public static <DAOInterface> DAOInterface createDAO(Class<?> entity){
		return (DAOInterface) listDAOsInterfaces.get(entity);
	} 
}
