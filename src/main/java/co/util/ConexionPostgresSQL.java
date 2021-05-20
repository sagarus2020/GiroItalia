package co.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPostgresSQL {

	private static ConexionPostgresSQL db;
	private Connection c = null;
	private PreparedStatement pr; //sentencia sql para interactuar con la DB
	
	String host = "queenie.db.elephantsql.com";
	String dbName = "mnjgxshj";
	String driver="org.postgresql.Driver";
	String url = "jdbc:postgresql://"+host+":5432/"+dbName;
	String usuario = "mnjgxshj";
	private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	
	private ConexionPostgresSQL() {
		
		try {
			Class.forName(driver).newInstance();
			c = (Connection)DriverManager.getConnection(url,usuario,password);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cerrarConexion()
	{
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Método para realizar consultas a la DB
	public ResultSet query() throws SQLException
	{
		ResultSet res = pr.executeQuery();
		return res;
	}
	
	//Método para actualizaciones a la DB (inserciones, borrados, actualizaciones)
	public int execute() throws SQLException
	{
		int result = pr.executeUpdate();
		return result;
	}
	
	//método para crear el statement dada una sentencia sql
	public void setPreparedStatement(String sql) throws SQLException
	{
		this.pr = c.prepareStatement(sql);
	}
	
	public PreparedStatement getPreparedStatement()
	{
		return this.pr;
	}
	
	public static ConexionPostgresSQL getConexion()
	{
		if(db==null)
			db = new ConexionPostgresSQL();
		return db;
	}
	
	
}
