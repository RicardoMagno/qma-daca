package com.ufcg.qmadaca.exception;

public class TutorNotFoundException extends RuntimeException {
	    public TutorNotFoundException() {
	        super("Tutor nao cadastrado");
		}
}
