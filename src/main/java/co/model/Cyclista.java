package co.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//get y set of variables
@Data
//constructor without parameters
@NoArgsConstructor
//constructor with all the parameters
@AllArgsConstructor
public class Cyclista implements Serializable {

	private int id;
	private String nombre;
	private String email;
    private String birthdate;
    private String country;
    private String team;
    
	public Cyclista(String nombre, String email,String birthdate, String country,String team) {
		this.nombre = nombre;
		this.email = email;
		this.nombre = birthdate;
		this.email = country;
		this.nombre = team;

	}



}
