package com.ufcg.qmadaca.dto;

import com.ufcg.qmadaca.entity.Tutor;

public class TutorDTO {
	
	private Long id;
    private String disciplina;
    private Integer proficiencia;   
    private Integer nota;
    private String nome;
    private String matricula;
    private String email;
    private Long studentId;

	public TutorDTO(Tutor t) {
		 this.proficiencia = t.getMastery();
		 this.nota = t.getNota();
		 this.disciplina = t.getDisciplina();
		 this.email = t.getEmail();
		 this.nome = t.getNome();
		 this.matricula = t.getMatricula();

	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(Integer proficiencia) {
		this.proficiencia = proficiencia;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
}
