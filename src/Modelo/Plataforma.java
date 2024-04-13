package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Plataforma implements Serializable {
	private ArrayList<Curso> cursos;
	
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public Plataforma() {
		this.cursos = new ArrayList<Curso>();
	} 

	public boolean existeIdCurso(int id) {
		for(Curso curso: this.cursos) {
			if(curso.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeNombreCorso(String Nombre) {
		for(Curso curso: this.cursos) {
			if(curso.Nombre.equalsIgnoreCase(null)) {
				return true;
			}
		}
		return false;
	}
	
	public int PosicionCurso(int id) {
		int cont = 0, i = 0;
		if(this.existeIdCurso(id)) {
			for(Curso curso: this.cursos) {
				cont ++;
				if(curso.getId() == id) {			
					i = cont;
				}
			}	
		}
		return i;
	}
	
	public void crearCurso(int id, String nombre,int creditos) throws Exception {
		if(this.existeIdCurso(id)) {
			throw new Exception("Ya existe un curso con esta id");
		}else if(this.existeNombreCorso(nombre)) {
			throw new Exception("Ya existe un curso con ese nombre");
		}else {
			Curso curso = new Curso(id, nombre, creditos);
			cursos.add(curso);
		}
	}
	
	
	public void ActualizarCurso(int id, String nombre, int creditos) throws Exception {
		if(this.existeIdCurso(id)) {
			throw new Exception("Ya existe un curso con esta id");
		}else if(this.existeNombreCorso(nombre)) {
			throw new Exception("Ya existe un curso con ese nombre");
		}else {
			Curso curso = new Curso(id, nombre, creditos);
			cursos.set(this.PosicionCurso(id), curso);
		}
	}
}
