package com.ufcg.qmadaca.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.ufcg.qmadaca.entity.Tutor;

public class TutorRequest {

    @NotBlank
    private String disciplina;

    @Min(1) @Max(5)
    private Integer proficiencia;
    
	@NotBlank
	private String matricula;

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
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public TutorRequest(Tutor t) {
		this.disciplina = t.getDisciplina();
		this.proficiencia = t.getMastery();
		this.matricula = t.getMatricula();
	}
}