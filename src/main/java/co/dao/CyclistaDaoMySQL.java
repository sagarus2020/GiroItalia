package co.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.model.Cyclista;
import co.util.ConexionMySQL;

public class CyclistaDaoMySQL {

	private ConexionMySQL c;
	//                          comando_objectoDB_tipo de dato                        
	private static final String INSERT_PROYECTO_SQL = "INSERT INTO proyecto (nombre,resumen) VALUES (?,?);";
	//private static final String DELETE_PROYECTO_SQL = "DELETE FROM proyecto WHERE id = ?;";
	private static final String UPDATE_PROYECTO_SQL = "UPDATE proyecto SET nombre=?,resumen=?  WHERE id = ?;";
	//private static final String SELECT_PROYECTO_BY_SQL = "SELECT * FROM proyecto WHERE id = ?;";
	//                          comando_objectoDB_por_tipo de dato 
	private static final String SELECT_PROYECTO_BY_ID = "SELECT * FROM proyecto WHERE id = ?;";
	private static final String SELECT_ALL_PROYECTOS = "SELECT * FROM proyecto;";
	
	public CyclistaDaoMySQL() {
		this.c = ConexionMySQL.getConexion();
	}

	public void insert(Cyclista proyecto) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_PROYECTO_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, proyecto.getNombre());
			pr.setString(2, proyecto.getResumen());
			
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Cyclista select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	


	public List<Cyclista> selectAll() throws SQLException{
		List<Cyclista> proyectos = new ArrayList<>();

		try {
			//strng sql que sirve como variable EXACTA de codigo
			c.setPreparedStatement(SELECT_ALL_PROYECTOS);
			PreparedStatement pr = c.getPreparedStatement();
			//el parametro id es por donde selecciona el buscador

			ResultSet rs = c.query();
			while(rs.next())
			{
				int id= rs.getInt("id");
				String nombre = rs.getString("nombre");
				String resumen = rs.getString("resumen");

				
				proyectos.add( new Cyclista (id,nombre,resumen) );
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
//		devuelve la lista
		return proyectos;
	}


	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public void update(Cyclista proyecto) throws SQLException {
		try {
			c.setPreparedStatement(UPDATE_PROYECTO_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			
			pr.setString(1, proyecto.getNombre());
			pr.setString(2, proyecto.getResumen());
			
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}