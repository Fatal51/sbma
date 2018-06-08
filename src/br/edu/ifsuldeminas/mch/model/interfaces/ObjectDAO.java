package br.edu.ifsuldeminas.mch.model.interfaces;

import java.util.List;

public interface ObjectDAO<T> {

	public boolean save(T objeto);

	public boolean delete(T objeto);
	
	public boolean alter(T objeto);

	public List<T> list();

	public T find(String name);
	
}
