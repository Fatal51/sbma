package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifsuldeminas.mch.model.Documento;
import br.edu.ifsuldeminas.mch.model.Usuario;

public class DAOFactory {
	
	private static Map<Class, Object> listDAOsInterfaces = new HashMap<Class, Object>();
	
	
	static {
		
		listDAOsInterfaces.put(Usuario.class, new UsuarioDAO());
		listDAOsInterfaces.put(Documento.class, new DocumentDAO());
	    
			
	}
	
	@SuppressWarnings("unchecked")
	public static <DAOInterface> DAOInterface createDAO(Class<?> entity){
		return (DAOInterface) listDAOsInterfaces.get(entity);
	} 
}
