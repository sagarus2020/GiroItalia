package co.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//get y set of variables
@Data
//constructor without parameters
@NoArgsConstructor
//constructor with all the parameters
@AllArgsConstructor

public class Team {
	private String id;
	private String nombre;
	private String country;
	
	public Team(String nombre, String country) {
		this.nombre = nombre;

	}
	

}
