package Control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Modelo.Curso;
import Modelo.Plataforma;
import Persistencia.ArchivoSerializable;

public class Principal {
	Plataforma plataforma;

	public Principal() {
		this.plataforma = new Plataforma();
		this.menu();
	}
	
	public static void main(String args[]) {
		new Principal();
	}

	private void menu() {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		
			do {
				try {
					System.out.println("Seleccione.");
					System.out.println("0.Salir.");
					System.out.println("1.Agregar un Curso.");
					System.out.println("2.Consultar Cursos.");
					System.out.println("3.Actualizar Cursos");
					System.out.println("4.Almacenar Cursos");
					System.out.println("5.Cargar Cursos");
					opc = sc.nextInt();
					if(opc == 0) {
						System.exit(0);
					}else if(opc == 1) {
						this.crearCurso(sc);
					}else if(opc == 2) {
						this.ImprimirCursos();
					}else if(opc == 3) {
						this.ModificarCurso(sc);
					}else if(opc == 4) {
						this.AlmacenarS();
					}else if(opc == 5) {
						this.CargarS();
					}
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
					
					
				
			}while(opc !=0);
			
		
	}

	private void crearCurso(Scanner sc) throws Exception {
		System.out.println("Ingrese:");
		System.out.println("Id.");
		int id = sc.nextInt();
		System.out.println("Nombre.");
		String nombre = sc.next();
		System.out.println("Creditos.");
		int creditos = sc.nextInt();
		this.plataforma.crearCurso(id, nombre, creditos);
	}
	private void ModificarCurso(Scanner sc) throws Exception {
		System.out.println("Ingrese:");
		System.out.println("Id de Curso a Modificar.");
		int id = sc.nextInt();
		System.out.println("Nombre nuevo de el Curso.");
		String nombre = sc.next();
		System.out.println("Creditos de el Curso.");
		int creditos = sc.nextInt();
		this.plataforma.ActualizarCurso(id, nombre, creditos);
	}

	private void ImprimirCursos() {
		System.out.println("Id1\tNombre\tCreditos");
		for(Curso cursos: this.plataforma.getCursos()) {
			System.out.println(cursos);
		}
	}
	
	private void CargarS() throws FileNotFoundException, ClassNotFoundException, IOException {
		this.plataforma = (Plataforma)ArchivoSerializable.cargar("Cursos.poo");
	}
	
	private void AlmacenarS() throws FileNotFoundException, IOException {
		ArchivoSerializable.almacenar("Cursos.poo", this.plataforma);
		
	}

}
