package co.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.model.Cyclista;
import co.util.ConexionPostgresSQL;

public class PaisDao {

	private ConexionPostgresSQL c;
	//                          comando_objectoDB_tipo de dato                        
	private static final String INSERT_PAIS_SQL = "INSERT INTO pais (nombre) VALUES (?,?);";
	private static final String DELETE_PAIS_SQL = "DELETE FROM pais WHERE id = ?;";
	private static final String UPDATE_PAIS_SQL = "UPDATE pais SET nombre=?  WHERE id = ?;";

	//                          comando_objectoDB_por_tipo de dato 
	private static final String SELECT_CYCLISA_BY_ID = "SELECT * FROM pais WHERE id = ?;";
	private static final String SELECT_ALL_PAISS = "SELECT * FROM pais;";
	
	public PaisDao() {
		this.c = ConexionPostgresSQL.getConexion();
	}

	public void insert(Cyclista pais) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_PAIS_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, pais.getNombre());
			pr.setString(2, pais.getEmail());
			pr.setString(3, pais.getBirthdate());
			pr.setString(4, pais.getCountry());
			pr.setString(5, pais.getTeam());
			
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
		List<Cyclista> paiss = new ArrayList<>();

		try {
			//strng sql que sirve como variable EXACTA de codigo
			c.setPreparedStatement(SELECT_ALL_PAISS);
			PreparedStatement pr = c.getPreparedStatement();
			//el parametro id es por donde selecciona el buscador

			ResultSet rs = c.query();
			while(rs.next())
			{
				int id= rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String birthdate = rs.getString("birthdate");
				String country = rs.getString("country");
				String team = rs.getString("team");

				
				paiss.add( new Cyclista (id,nombre,email,birthdate,country,team) );
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
//		devuelve la lista
		return paiss;
	}


	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public void update(Cyclista pais) throws SQLException {
		try {
			c.setPreparedStatement(UPDATE_PAIS_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			
			pr.setString(1, pais.getNombre());

			
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
