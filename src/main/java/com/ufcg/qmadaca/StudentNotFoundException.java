package com.ufcg.qmadaca;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super("Aluno nao cadastrado");
	}
}
