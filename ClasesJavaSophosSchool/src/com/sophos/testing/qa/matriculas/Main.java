package com.sophos.testing.qa.matriculas;

public class Main {

	public static void main(String[] args) {
		try {
			//Cursos
			Curso curso1 = new Curso(1, "java", "Lunes 9am-12m");
			Curso curso2 = new Curso(2, ".net", "Martes 9am-12m");
			Curso curso3 = new Curso(3, "selenium", "Miercoles 9am-12m");
			
			//profesores
			Profesor profesor1 = new Profesor("Juan", "123");
			Profesor profesor2 = new Profesor("Pedro", "124");
			Profesor profesor3 = new Profesor("Andres", "125");
			
			//Estudiantes
			Estudiante estudiante1 = new Estudiante("Daniel", "126");
			Estudiante estudiante2 = new Estudiante("Diana", "127");
			
			profesor1.setCurso(curso1);
			profesor2.setCurso(curso3);
			
			estudiante1.agregarCurso(curso1);
			estudiante1.agregarCurso(curso2);
			estudiante1.agregarCurso(curso3);
			
			estudiante2.agregarCurso(curso1);
			estudiante2.agregarCurso(curso3);		
			
			//indice no valido
			//System.out.println(estudiante1.getCursos().get(80).toString());
			// tiene curso asignado
			System.out.println(profesor1.getCurso().toString());
			//no tiene curso asignado
			//System.out.println(profesor3.getCurso().toString());
			// tiene cursos
			System.out.println(estudiante1.getCursos().toString());
			
			System.gc();			
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.err.println("No tiene curso asignado");
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
			System.err.println("Indice no valido");
		}
		
	}

}
