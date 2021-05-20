package co.model;

import java.io.Serializable;
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
	private String resumen;

	public Cyclista(String nombre, String resumen) {
		this.nombre = nombre;
		this.resumen = resumen;
	}



}
