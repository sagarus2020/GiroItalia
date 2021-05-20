package co.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.model.Team;
import co.util.ConexionPostgresSQL;

public class TeamDao {

	private ConexionPostgresSQL c;
	//                          comando_objectoDB_tipo de dato                        
	private static final String INSERT_PAIS_SQL = "INSERT INTO team (name,country) VALUES (?,?);";
	private static final String DELETE_PAIS_SQL = "DELETE FROM team WHERE id = ?;";
	private static final String UPDATE_PAIS_SQL = "UPDATE team SET nombre=?, country=?  WHERE id = ?;";

	//                          comando_objectoDB_por_tipo de dato 
	private static final String SELECT_CYCLISA_BY_ID = "SELECT * FROM team WHERE id = ?;";
	private static final String SELECT_ALL_PAISES = "SELECT * FROM team;";
	
	public TeamDao() {
		this.c = ConexionPostgresSQL.getConexion();
	}

	public void insert(Team team) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_PAIS_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, team.getNombre());

			
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Team select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	


	public List<Team> selectAll() throws SQLException{
		List<Team> teams = new ArrayList<>();

		try {
			//strng sql que sirve como variable EXACTA de codigo
			c.setPreparedStatement(SELECT_ALL_PAISES);
			PreparedStatement pr = c.getPreparedStatement();
			//el parametro id es por donde selecciona el buscador

			ResultSet rs = c.query();
			while(rs.next())
			{
				String id= rs.getString("id");
				String nombre = rs.getString("name");
				String country = rs.getString("country");


				
				teams.add( new Team (id,nombre,country) );
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
//		devuelve la lista
		return teams;
	}


	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public void update(Team team) throws SQLException {
		try {
			c.setPreparedStatement(UPDATE_PAIS_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			
			pr.setString(1, team.getNombre());
			pr.setString(2, team.getCountry());
			
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}