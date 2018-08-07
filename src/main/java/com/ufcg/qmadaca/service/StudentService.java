package com.ufcg.qmadaca.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufcg.qmadaca.dto.StudentDTO;
import com.ufcg.qmadaca.dto.TutorDTO;
import com.ufcg.qmadaca.entity.Role;
import com.ufcg.qmadaca.entity.Student;
import com.ufcg.qmadaca.entity.Tutor;
import com.ufcg.qmadaca.exception.StudentNotFoundException;
import com.ufcg.qmadaca.repositoty.StudentRepository;
import com.ufcg.qmadaca.repositoty.TutorRepository;

@Service
public class StudentService {
	
    private ModelMapper modelMapper;

    private TypeMap<Student, StudentDTO> studentToDTO;
    
    private TypeMap<Tutor, TutorDTO> tutorToDTO;
    
	@Autowired
	StudentRepository sr;
	
	@Autowired
	TutorRepository tr;
	
    @Autowired
    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.sr = studentRepository;
        this.modelMapper = modelMapper;
        setStudentMapping();
    }

	@Transactional
	public void cadastrarAluno(String nome, String matricula, String codigoCurso, String telefone, String email, String senha) {
		Student entity = new Student(matricula, codigoCurso, nome, email, senha, telefone);
		entity.setRoles(Collections.singleton(Role.ROLE_ALUNO));
		sr.save(entity);
	}
	
    @Transactional
    public void tornarTutor(String matricula, String disciplina, int proficiencia) {
        Student aluno = recuperaAluno(matricula);
        Tutor tutor = new Tutor(aluno.getMatricula(), aluno.getCode(), aluno.getNome(), aluno.getEmail(), aluno.getSenha(), aluno.getTelefone(), disciplina, proficiencia);
        //tutor.setAluno(aluno);
        tr.save(tutor);

        //aluno.addTutor(tutor);
        aluno.getRoles().add(Role.ROLE_TUTOR);
        sr.save(aluno);
    }
    
    private void setStudentMapping() {
        studentToDTO = this.modelMapper.createTypeMap(Student.class, StudentDTO.class);
    }
	
	public List<StudentDTO> listarAlunos() {
		List<Student> alunos = sr.findAll();
		return convertStudent(alunos);
	}
    public List<TutorDTO> listarTutors() {
        Collection<Tutor> tutors = (List<Tutor>) tr.findAll();
        return convertTutors(tutors);
    }			

	@Transactional
	public StudentDTO recuperaAlunoDTO(String matricula) {
		try {
		Student student = sr.findByMatricula(matricula);
		return studentToDTO.map(student);
		}
		catch(StudentNotFoundException ex) {
            throw ex;	
		}
	}
    public TutorDTO recuperaTutor(String matricula) {
    	TutorDTO dto = new TutorDTO((tr.findByMatricula(matricula)));
        return dto;
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
	public String getInfoAluno(String matricula) {
		return sr.findByMatricula(matricula).toString();
	}
	
    private Student recuperaAluno(String matricula) {
		try {
		return sr.findByMatricula(matricula);
		}
		catch(StudentNotFoundException ex) {
            throw ex;	
		}
    }
    
	private List<StudentDTO> convertStudent(Collection<Student> alunos) {
		return alunos.stream().map(student -> studentToDTO.map(student)).collect(Collectors.toList());
	}
    private List<TutorDTO> convertTutors(Collection<Tutor> tutors) {
        return tutors.stream().map(tutor -> tutorToDTO.map(tutor)).collect(Collectors.toList());
    }
}
