package com.ufcg.qmadaca.exception;

public class TutorAlredySaveException extends Exception {
    public TutorAlredySaveException() {
        super("Tutor já cadastrado");
	}
}
