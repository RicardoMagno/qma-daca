package com.ufcg.qmadaca;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorH2DatabaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository sr;
	
	@Transactional
	public void cadastrarAluno(String nome, String matricula, String codigoCurso, String telefone, String email, String senha) {
		Student entity = new Student(matricula, codigoCurso, nome, email, senha, telefone);
		//student.setRoles(Collections.singleton(Role.ROLE_STUDENT));
		sr.save(entity);
	}

	
	public List<Student> listarAlunos() {
		List<Student> students = (List<Student>) sr.findAll();
		return students;
	}
				

	@Transactional
	public Student recuperaAluno(String matricula) {
		try {
		Student student = sr.findByMatricula(matricula);
		return sr.findByMatricula(matricula);
		}
		catch(StudentNotFoundException ex) {
            throw ex;	
		}
	}

    public void removeById(Long id) {
        sr.deleteById(id);
    }

    public Boolean matriculaUnica(String matricula) {
        return sr.existsByMatricula(matricula);
    }

    public Boolean emailUnico(String email) {
        return sr.existsByEmail(email);
    }
    
	@Transactional
	public String getInfoAluno(String matricula, String atributo) {
		return sr.findByMatricula(matricula).toString();
	}

}
