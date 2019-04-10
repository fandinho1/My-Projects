package com.sophos.testing.qa.matriculas;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String cedula;
	private ArrayList<Curso> cursos;
	
	public Estudiante(String nombre, String cedula) {
		this.nombre=nombre;
		this.cedula=cedula;
		this.cursos=new ArrayList<>();
	}	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public ArrayList<Curso> getCursos() {
		return cursos;
	}
	public void agregarCurso(Curso curso) {
		this.cursos.add(curso);
	}
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", cedula=" + cedula + ", cursos=" + cursos + "]";
	}	
	
}
