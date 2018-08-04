package com.ufcg.qmadaca;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Tutor {

   private Set<Student> alunos;
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	public int proficiencia;
	@Column
	public String disciplina;
	private Student aluno;
	
	@Min(0)
	@Max(5)
	@Column
	private int nota = 5;
	
	public Tutor(Student aluno, String disciplina, int proficiencia) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.proficiencia = proficiencia;
	}
	
	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public int getMastery(int proficiencia) {
		return proficiencia;		
	}
	public void setMastery(int proficiencia) {
		this.proficiencia = proficiencia;		
	}

}