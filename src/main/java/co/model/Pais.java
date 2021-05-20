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

public class Pais {
	private String id;
	private String nombre;
	
	public Pais(String nombre) {
		this.nombre = nombre;

	}
	
}
