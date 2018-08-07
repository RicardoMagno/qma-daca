package com.ufcg.qmadaca.dto;

import java.util.Set;

import com.ufcg.qmadaca.entity.Student;
import com.ufcg.qmadaca.entity.Tutor;


public class StudentDTO {

	private Long id;
    private String matricula;
    private String codigoCurso;
    private String nome;
    private String email;
    private String telefone;
    private Integer nota;
    private Set<Tutor> tutores;

	public StudentDTO(Student s) {
		 this.matricula = s.getMatricula();
		 this.codigoCurso = s.getCode();
		 this.nome = s.getNome();
		 this.email = s.getEmail();
		 this.telefone = s.getTelefone();
//		 this.tutores = s.getTutores();

	}
}

