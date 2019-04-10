package com.yahoo.espanol.qa.miprimerabusqueda.exceptions;

public class PhraseNotFound extends AssertionError{
	
	public static final String PHRASE_NOT_FOUND = "The phrase found does not match the search";
	
	public PhraseNotFound(String message, Throwable cause) {
		super(message,cause);
	}
}
