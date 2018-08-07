package com.ufcg.qmadaca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "tutors")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Tutor extends Student{

   //private Set<Student> alunos;
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	public int proficiencia;
	
	@Column
	public String disciplina;
	
	@Min(0)
	@Max(5)
	@Column
	private int nota = 5;

	public Tutor(String matricula , String codigoCurso, String nome, String email, String senha, String telefone, String disciplina, int proficiencia) {
		super( matricula,  codigoCurso, nome, email, senha, telefone);
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
	public int getMastery() {
		return proficiencia;		
	}
	public void setMastery(int proficiencia) {
		this.proficiencia = proficiencia;		
	}
}