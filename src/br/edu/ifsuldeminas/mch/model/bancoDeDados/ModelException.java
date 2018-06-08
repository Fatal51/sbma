package br.edu.ifsuldeminas.mch.model.bancoDeDados;

public class ModelException extends Exception {

	private static final long serialVersionUID = 1L;

	public ModelException(String message) {
		super(message);
	}
	
	public ModelException(String message, Throwable cause) {
		super(message, cause);
	}
}
