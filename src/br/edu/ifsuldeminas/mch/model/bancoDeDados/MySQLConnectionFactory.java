package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory {

	// Nome do Driver (classe) e URL do banco
	private static final String JDBC_DRIVER_NAME = 
			"com.mysql.jdbc.Driver";
	
	private static final String DATABASE_URL = 
			"jdbc:mysql://127.0.0.1/sbma";

	// Credenciais
	private static final String USER = "root";
	private static final String PASSWORD = "@#$@#$";
	
	public static Connection getConnection() throws ModelException {
		// API JDBC < 3 e Java < 5
		try {
			Class.forName(JDBC_DRIVER_NAME);
			
			// Cria uma conexÃ£o com o Banco de Dados
			return DriverManager.getConnection(
					DATABASE_URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new ModelException("Driver não encontrado", e);
		} catch (SQLException e) {
			throw new ModelException("Falha na conexão com o BD", e);
		}
	}
}
