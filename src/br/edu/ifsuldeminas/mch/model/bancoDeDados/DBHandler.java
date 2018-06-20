package br.edu.ifsuldeminas.mch.model.bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHandler {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public DBHandler() throws ModelException {
		connection =  MySQLConnectionFactory.getConnection();
	}

	public void prepareStatement(String sqlInsert) throws ModelException {
		try {
			preparedStatement = connection.prepareStatement(sqlInsert);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao preparar a SQL", e);
		}
	}
	

	public void setString(int i, String value) throws ModelException {
		validatePreparedStatement();
		
		try {
			preparedStatement.setString(i, value);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao atribuir string", e);
		}
	}
	
	public void setDate(int i, Date data) throws ModelException{
		validatePreparedStatement();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		
		try{
		preparedStatement.setString(i, sdf.format(data));
		}catch(SQLException e){
			close();
			throw new ModelException("erro a atribuir data", e);
		}
	}
	
	public void setDouble(int i, Double valor) throws ModelException{
		validatePreparedStatement();
		try{
		preparedStatement.setDouble(i, valor);
		}catch(SQLException e){
			close();
			throw new ModelException("erro a atribuir double", e);
		}
	}
	
	public void setBoolean(int i, boolean valor) throws ModelException{
		validatePreparedStatement();
		try{
		preparedStatement.setBoolean(i, valor);
		}catch(SQLException e){
			close();
			throw new ModelException("erro a atribuir boolean", e);
		}
	}

	public void setInt(int i, int value) throws ModelException {
		validatePreparedStatement();
		
		try {
			preparedStatement.setInt(i, value);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao atribuir inteiro", e);
		}
	}

	public int executeUpdate() throws ModelException  {
		validatePreparedStatement();
		
		try {
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new ModelException("Erro ao executar SQL", e);
		} finally{
			close();
		}
	}
	
	public void createStatement() throws ModelException {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new ModelException("Erro ao criar o statement", e);
		}
	}
	
	public void executeQuery(String sql) throws ModelException {
		validateStatement();
		
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao executar SQL", e);
		}
	}
	
	public void executeQuery() throws ModelException {
		validatePreparedStatement();
		
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao executar SQL", e);
		}
	}
	
	public boolean next() throws ModelException {
		validateResultSet();
		
		try {
			return resultSet.next();
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao chamar pr√≥ximo registro", e);
		}
	}
	
	public int getInt(String column) throws ModelException {
		try {
			return resultSet.getInt(column);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao chamar getInt", e);
		}
	}
	
	public boolean getBoolean(String column) throws ModelException {
		try {
			return resultSet.getBoolean(column);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao chamar booelan", e);
		}
	}
	
	public String getString(String column) throws ModelException {
		try {
			return resultSet.getString(column);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao chamar getString", e);
		}
	}
	
	public Date getDate(String column) throws ModelException {
		try {
			return resultSet.getDate(column);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao chamar getDate", e);
		}
	}
	
	public Double getDouble(String column) throws ModelException {
		try {
			return resultSet.getDouble(column);
		} catch (SQLException e) {
			close();
			throw new ModelException("Erro ao chamar double", e);
		}
	}
	
	private void close() throws ModelException {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
			
			if (statement != null)
				statement.close();
			
			if (resultSet != null)
				resultSet.close();
			
			connection.close();
		} catch (SQLException e) {
			throw new ModelException("Erro ao fechar recursos", e);
		}
	}
	
	private void validatePreparedStatement() throws ModelException {
		if (preparedStatement == null)
			throw new ModelException("Preparede Statement n„oo foi criado");
	}

	private void validateStatement() throws ModelException {
		if (statement == null)
			throw new ModelException("Statement n„oo foi criado");
	}

	private void validateResultSet() throws ModelException {
		if (resultSet == null)
			throw new ModelException("Result set n„oo foi criado");
	}
}
