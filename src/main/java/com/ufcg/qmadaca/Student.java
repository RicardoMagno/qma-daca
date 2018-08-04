package com.ufcg.qmadaca;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	
	@ManyToOne
	private Set<Tutor> tutores;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column
	private String matricula;
	//TODO: impossivel ter nomes vazios ou em branco
	@Column
	private String nome;
	
	@Size(min = 11, max = 13)
	@Column
	private String telefone;
	
	@Column
	private String codigoCurso;
	
	@Email
	@Column
	private String email;

	@JsonIgnore
	@NotBlank
	private String senha;
	
	@Min(0)
	@Max(5)
	@Column
	private int nota = 5;
	
    public Student(String matricula , String codigoCurso, String nome, String email, String senha, String telefone) {
	 this.matricula = matricula;
	 this.codigoCurso = codigoCurso;
	 this.nome = nome;
	 this.email = email;
	 this.senha = senha;
	 this.telefone = telefone;
	 this.tutores = new HashSet<>();
	}
	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@NotBlank
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCode() {
		return codigoCurso;
	}
	public void setCode(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getNota() {
	    return nota;
	}
	public void setNota(int nota) {
	    this.nota = nota;
	}
}