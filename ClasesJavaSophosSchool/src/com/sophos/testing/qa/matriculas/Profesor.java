package com.sophos.testing.qa.matriculas;

public class Profesor {
	private String nombre;
	private String cedula;
	private Curso curso;
	
	public Profesor(String nombre, String cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.curso = null;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", cedula=" + cedula + ", curso=" + curso + "]";
	}
	

}
