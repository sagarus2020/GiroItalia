package co.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.model.Cyclista;
import co.util.ConexionPostgresSQL;

public class CyclistaDao {

	private ConexionPostgresSQL c;
	//                          comando_objectoDB_tipo de dato                        
	private static final String INSERT_CYCLIST_SQL = "INSERT INTO cyclist (nombre,email,birthdate,country,team) VALUES (?,?,?,?,?);";
	private static final String DELETE_CYCLIST_SQL = "DELETE FROM cyclista WHERE id = ?;";
	private static final String UPDATE_CYCLIST_SQL = "UPDATE cyclist SET nombre=?,email=?,birthdate=?,country=?,team=?  WHERE id = ?;";

	//                          comando_objectoDB_por_tipo de dato 
	private static final String SELECT_CYCLISA_BY_ID = "SELECT * FROM cyclista WHERE id = ?;";
	private static final String SELECT_ALL_CYCLISTS = "SELECT * FROM cyclista;";
	
	public CyclistaDao() {
		this.c = ConexionPostgresSQL.getConexion();
	}

	public void insert(Cyclista cyclista) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_CYCLIST_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, cyclista.getNombre());
			pr.setString(2, cyclista.getEmail());
			pr.setString(3, cyclista.getBirthdate());
			pr.setString(4, cyclista.getCountry());
			pr.setString(5, cyclista.getTeam());
			
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
		List<Cyclista> cyclistas = new ArrayList<>();

		try {
			//strng sql que sirve como variable EXACTA de codigo
			c.setPreparedStatement(SELECT_ALL_CYCLISTS);
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

				
				cyclistas.add( new Cyclista (id,nombre,email,birthdate,country,team) );
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
//		devuelve la lista
		return cyclistas;
	}


	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public void update(Cyclista cyclista) throws SQLException {
		try {
			c.setPreparedStatement(UPDATE_CYCLIST_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			
			pr.setString(1, cyclista.getNombre());

			
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}