package com.ufcg.qmadaca.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Aluno nao cadastrado");
	}
}
