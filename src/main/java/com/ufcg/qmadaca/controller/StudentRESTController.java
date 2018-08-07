package com.ufcg.qmadaca.controller;

import java.rmi.StubNotFoundException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.qmadaca.dto.StudentDTO;
import com.ufcg.qmadaca.entity.Student;
import com.ufcg.qmadaca.service.StudentService;

import com.ufcg.qmadaca.dto.TutorDTO;
import com.ufcg.qmadaca.entity.Tutor;
import com.ufcg.qmadaca.entity.Ajuda;
import com.ufcg.qmadaca.exception.ObjectInvalidException;
import com.ufcg.qmadaca.exception.StudentAlredySaveException;
import com.ufcg.qmadaca.exception.StudentNotFoundException;
import com.ufcg.qmadaca.exception.TutorAlredySaveException;
import com.ufcg.qmadaca.exception.TutorNotFoundException;
import com.ufcg.qmadaca.util.CustomErrorType;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentRESTController {
	
	private StudentService studentService;
	
	//private final TutorService tutorService;
	
//	void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email)
    @RequestMapping(value = "/aluno/", method = RequestMethod.POST)
    public ResponseEntity<?> cadastrarAluno(@RequestBody Student aluno, UriComponentsBuilder ucBuilder) throws StudentNotFoundException, StudentAlredySaveException {
    	studentService.cadastrarAluno(aluno.getNome(), aluno.getMatricula(), aluno.getCode(), aluno.getTelefone(), aluno.getEmail(), aluno.getSenha());
        return new ResponseEntity<Student>(aluno, HttpStatus.CREATED);
    }
    
//	String recuperaAluno(String matricula)
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/aluno/{matricula}", method = RequestMethod.GET)
    public ResponseEntity<?> recuperaAlunoDTO(@PathVariable("matricula") String matricula) throws StudentNotFoundException, Exception {

    	StudentDTO aluno = studentService.recuperaAlunoDTO(matricula);
        if (aluno == null) {
            return new ResponseEntity(new CustomErrorType("Aluno with matricula " + matricula + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StudentDTO>(aluno, HttpStatus.OK);
    }
    
//	String getInfoAluno(String matricula)
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/aluno/{info}", method = RequestMethod.GET)
    public ResponseEntity<?> getInfoAluno(@PathVariable("info") String matricula) throws StubNotFoundException, Exception {

    	String informacao = studentService.getInfoAluno(matricula);
        if (informacao == null) {
            return new ResponseEntity(new CustomErrorType("Informação do Aluno with matricula " + matricula + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(informacao, HttpStatus.OK);
    }
    
//	String listarAlunos()
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/aluno/all", method = RequestMethod.GET)
    public ResponseEntity<?> listarAlunos(@PathVariable("alunos") String matricula) throws StubNotFoundException, Exception {

    	List<StudentDTO> alunos = studentService.listarAlunos();
        if (alunos == null) {
            return new ResponseEntity(new CustomErrorType("Nenhum aluno cadastrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<StudentDTO>>(alunos, HttpStatus.OK);
    }
	

    //void tornarTutor(String matricula, String disciplina, int proficiencia)
    @RequestMapping(value = "/tutor/", method = RequestMethod.POST)
    public ResponseEntity<?> cadastrarTutor(@RequestBody Tutor tutor, UriComponentsBuilder ucBuilder) throws TutorNotFoundException, TutorAlredySaveException, ObjectInvalidException, Exception {
    	studentService.tornarTutor(tutor.getMatricula(), tutor.getDisciplina(), tutor.proficiencia);
    	return new ResponseEntity<Tutor>(tutor, HttpStatus.CREATED);
    }
    
    //String recuperaTutor(String matricula)
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/tutor/{matricula}", method = RequestMethod.GET)
    public ResponseEntity<?> recuperaTutor(@PathVariable("matricula") String matricula) throws TutorNotFoundException, Exception {

        TutorDTO tutor = studentService.recuperaTutor(matricula);
        if (tutor == null) {
            return new ResponseEntity(new CustomErrorType("Tutor with matricula " + matricula + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TutorDTO>(tutor, HttpStatus.OK);
    }
    
    //String listarTutores()
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/tutor/all", method = RequestMethod.GET)
    public ResponseEntity<?> listarTutores(@PathVariable("tutores") String matricula) throws StubNotFoundException, Exception {

    	List<TutorDTO> tutores = studentService.listarTutors();
        if (tutores == null) {
            return new ResponseEntity(new CustomErrorType("Nenhum Tutor cadastrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<TutorDTO>>(tutores, HttpStatus.OK);
    }
}