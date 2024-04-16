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
	
	public int PosicionCurso(int id) {
		int cont = 0, i = 0;
		if(this.cursos.containsKey(id)) {
			for(Integer Id: this.cursos.keySet()) {
				Curso curso = this.cursos.get(Id);
				cont ++;
				if(curso.getId() == id) {			
					i = cont;
				}
			}	
		}
		return i;
	}
	
	public void crearCurso(int id, String nombre,int creditos) throws Exception {
		if(this.cursos.containsKey(id)) {
			throw new Exception("Ya existe un curso con esta id");
		}else {
			Curso curso = new Curso(id, nombre, creditos);
			cursos.put(id, curso);
		}
	}
}
