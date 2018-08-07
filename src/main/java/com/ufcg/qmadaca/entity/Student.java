package com.ufcg.qmadaca.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "alunos", uniqueConstraints = { @UniqueConstraint(columnNames = {"email", "matricula"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {
	
//	@OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER)
//	private Set<Tutor> tutores;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String matricula;
	
	@NotBlank
	private String nome;
	
	@Size(min = 11, max = 13)
	private String telefone;
	
	private String codigoCurso;
	
	@Email
	private String email;

	@JsonIgnore	@NotBlank
	private String senha;
	
	@Min(0)	@Max(5)
	private int nota = 5;
	
	String notelefone = "00000000000"; 
	
    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "roles")
    @Column(name = "roles", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
	
    public Student(String matricula , String codigoCurso, String nome, String email, String senha, String telefone) {
	 this.matricula = matricula;
	 this.codigoCurso = codigoCurso;
	 this.nome = nome;
	 this.email = email;
	 this.senha = senha;
	 this.telefone = telefone;
//	 this.tutores = new HashSet<>();
	}
    public Student(String matricula , String codigoCurso, String nome, String email, String senha) {
	 this.matricula = matricula;
	 this.codigoCurso = codigoCurso;
	 this.nome = nome;
	 this.email = email;
	 this.senha = senha;
	 this.telefone = notelefone;
//	 this.tutores = new HashSet<>();
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

//	public Set<Tutor> getTutores() {
//		return tutores;
//	}
//
//    public void setTutors(Set<Tutor> tutores) {
//        this.tutores = tutores;
//    }
//
//    public void addTutor(Tutor tutor) {
//        this.tutores.add(tutor);
//    }
	@Override
	public String toString() {
		String s = getMatricula() + " - " + getNome() + " - " + getCode() + " - "
				+ getTelefone() + " - " + getEmail();
		return s;	
	}
	
	public String noTelToString() {
		String s = getMatricula() + " - " + getNome() + " - " + getCode() + " - "
				+ getEmail();
		return s;	
	}
	public void setRoles(Set<Role> role) {
		this.roles = role;
		
	}
	public Set<Role> getRoles() {
		return roles;
	}
}