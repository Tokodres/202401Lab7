package Modelo;

import java.io.Serializable;
import java.util.HashMap;


public class Plataforma implements Serializable {
	private HashMap<Integer, Curso> cursos;

	public HashMap<Integer, Curso> getCursos() {
		return cursos;
	}

	public Plataforma() {
		this.cursos = new HashMap<Integer, Curso>();
	} 
	
	public void crearCurso(int id, String nombre,int creditos) throws Exception {
		if(this.cursos.containsKey(id)) {
			throw new Exception("Ya existe un curso con esta id");
		}else {
			Curso curso = new Curso(id, nombre, creditos);
			cursos.put(id, curso);
		}
	}

	public void ModificarCurso(int id, String nombre,int creditos) throws Exception {
		if(!this.cursos.containsKey(id)) {
			throw new Exception("Ya existe un curso con esta id");
		}else {
			Curso curso = new Curso(id, nombre, creditos);
			cursos.replace(id, curso);
		}
	}
	
	
}
