package com.ufcg.qmadaca.exception;

public class StudentAlredySaveException extends Exception {
    public StudentAlredySaveException() {
        super("Aluno já cadastrado");
	}
}
