package com.ufcg.qmadaca.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufcg.qmadaca.dto.TutorDTO;
import com.ufcg.qmadaca.dto.TutorRequest;
import com.ufcg.qmadaca.entity.Role;
import com.ufcg.qmadaca.entity.Student;
import com.ufcg.qmadaca.entity.Tutor;
import com.ufcg.qmadaca.exception.StudentNotFoundException;
import com.ufcg.qmadaca.exception.TutorNotFoundException;
import com.ufcg.qmadaca.repositoty.StudentRepository;
import com.ufcg.qmadaca.repositoty.TutorRepository;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TutorService {

    private TutorRepository tutorRepository;

    private StudentRepository sr;


    private TypeMap<Tutor, TutorDTO> tutorToDTO;

    @Autowired
    public TutorService(TutorRepository tutorRepository, StudentRepository studentRepository) {
        this.tutorRepository = tutorRepository;
        this.sr = studentRepository;
    }

    @Transactional
    public TutorDTO virarTutor(@Valid TutorRequest tutorRequest, String matricula) {
        Student student = recuperaAluno(matricula);
        Tutor tutor = new Tutor(matricula, student.getCode(), student.getNome(), student.getEmail(),
        		student.getSenha(), student.getTelefone(), tutorRequest.getDisciplina(), tutorRequest.getMastery());
        tutorRepository.save(tutor);

        //student.addTutor(tutor);
        student.getRoles().add(Role.ROLE_TUTOR);
        sr.save(student);
        return this.tutorToDTO.map(tutor);
    }

    public TutorDTO getTutoresByMatricula(String matricula) {
    	TutorDTO tutor = new TutorDTO(tutorRepository.findByMatricula(matricula));
    	return tutor;
        
    }

    public List<TutorDTO> getAll() {
        Collection<Tutor> tutors = (List<Tutor>) tutorRepository.findAll();
        return convertTutors(tutors);
    }

    public void removeTutor(Long id, Collection<Tutor> tutors) {
        existsTutor(id, tutors);
        tutorRepository.deleteById(id);
    }

    public TutorDTO update(Long id, TutorRequest tutorRequest, Collection<Tutor> tutors) {
        Tutor tutor = existsTutor(id, tutors);
        //modelMapper.map(tutorRequest, tutor);
        return tutorToDTO.map(tutorRepository.save(tutor));
    }

    private Student recuperaAluno(String matricula) {
		try {
		return sr.findByMatricula(matricula);
		}
		catch(StudentNotFoundException ex) {
            throw ex;	
		}
    }

    private Tutor existsTutor(Long id, Collection<Tutor> tutors) {
        for (Tutor tutor: tutors) {
            if(tutor.getId().equals(id)) {
                return tutor;
            }
        }
        throw new TutorNotFoundException();
    }

    private List<TutorDTO> convertTutors(Collection<Tutor> tutors) {
        return tutors.stream().map(tutor -> tutorToDTO.map(tutor)).collect(Collectors.toList());
    }
}