package com.ufcg.qmadaca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	public Long id;
	
	@Column
	public String registry;
	//TODO: impossivel ter nomes vazios ou em branco
	@Column
	public String name;
	
	@Column
	public String phone;
	@Column
	public int courseCode;
	//TODO: email deve ser obrigatorio e valido()um arroba e algo antes e depois do @
	@Column
	public String email;
	//TODO aluno possui uma nota de avaliação (entre 0 e 5), inicialmente 5
	@Column
	public int grade;
	
	@Column
	public boolean tutelagem;
	
	@Column
	public int proficiencia;
	
	@Column
	public String disciplina;
	
	
	public String getRegistry() {
		return registry;
	}
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
    @Override
    public String toString() {
    	if(phone.isEmpty()) {
    		return registry + " - " + name + " - " + courseCode + " - " + email;
    	}
    	else {
    		return registry + " - " + name + " - " + courseCode + " - "+ phone + " - " + email;
    	}
    }
  //Como sistema, deve ser possível cadastrar alunos para que os mesmos fiquem registrados e possam ser recuperados pela matrícula.
	public void setTutelagem(boolean tutelar) {
		this.tutelagem = tutelar;		
	}
	public void setClass(String disciplina2) {
		this.disciplina = disciplina2;
	}
	public void setMastery(int proficiencia2) {
		this.proficiencia = proficiencia2;		
	}

  //Na listagem de alunos, deve ser exibido um aluno por linha, ordenados a partir do nome.

}