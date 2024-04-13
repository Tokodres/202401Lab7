package Modelo;

import java.io.Serializable;

public class Curso implements Serializable {
	private int id;
	public String Nombre;
	public int Creditos;
	
	public Curso(int id, String nombre, int creditos) {
		this.id = id;
		Nombre = nombre;
		Creditos = creditos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		
		return this.id + "\t" + this.Nombre +"\t" + this.Creditos;
	}
	
}
