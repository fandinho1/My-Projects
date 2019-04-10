package com.yahoo.espanol.qa.miprimerabusqueda.models;

public class Phrase {
	private String cadenaUno;
	private String cadenaDos;
	
	public Phrase(String cadenaUno, String cadenaDos) {
		this.cadenaUno=cadenaUno;
		this.cadenaDos=cadenaDos;
	}

	public String getCadenaUno() {
		return cadenaUno;
	}

	public void setCadenaUno(String cadenaUno) {
		this.cadenaUno = cadenaUno;
	}

	public String getCadenaDos() {
		return cadenaDos;
	}

	public void setCadenaDos(String cadenaDos) {
		this.cadenaDos = cadenaDos;
	}
	
}
