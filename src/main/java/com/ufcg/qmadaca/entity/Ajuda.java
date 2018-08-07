package com.ufcg.qmadaca.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Ajuda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String disciplina;
	
	@NotBlank
	private String horario;
	
	@NotBlank
	private String dia;
	
	private String local;
	
	private Student aluno;
	private Tutor tutor;
	private Boolean avaliacao;

	public Ajuda(int id, String disciplina, String horario, String dia, String local, Student aluno, Tutor tutor) {
		super();
		this.disciplina = disciplina;
		this.horario = horario;
		this.dia = dia;
		this.local = local;
		this.aluno = aluno;
		this.tutor = tutor;
		this.avaliacao = false;
	}
	
	public Ajuda(int id, String matrAluno, String disciplina, Student aluno, Tutor tutor) {
		super();
		this.disciplina = disciplina;
		this.aluno = aluno;
		this.tutor = tutor;
		this.avaliacao = false;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Student getAluno() {
		return aluno;
	}

	public void setAluno(Student aluno) {
		this.aluno = aluno;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Boolean getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Boolean avaliacao) {
		this.avaliacao = avaliacao;
	}

}