package com.sophos.testing.qa.matriculas;

public class Curso {
	private int idCurso;
	private String nombre, horario;
	
	public Curso(int id, String nombre,String horario) {
		this.idCurso=id;
		this.nombre=nombre;
		this.horario=horario;		
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", nombre=" + nombre + ", horario=" + horario + "]";
	}
	

}
