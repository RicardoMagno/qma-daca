package com.ufcg.qmadaca;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

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
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Student entity = new Student();
		entity.setRegistry(matricula);
		entity.setName(nome);
		entity.setCode(codigoCurso);
		entity.setPhone(telefone);
		entity.setEmail(email);
		sr.save(entity);
	}
	@Transactional
	public List<Student> recuperaAluno(String matricula) {
		return sr.findByRegistry(matricula);
	}
//	@Transactional
//	public String listarAlunos() {
//		Iterable<Student> alunos = sr.findAll();
//		Iterator<Student> iterator = alunos.iterator();
//		List<String> list = new ArrayList<String>();
//		while(iterator.hasNext()) {
//			adicionarCorreto(list, iterator.next());			
//		}
//		return listaAlunos;
//	}
//	private void adicionarCorreto(List<String> list, Student next) {
//		if(list.isEmpty()) {
//			list.add(next.toString());
//		}	
//	}
	@Transactional
	public String getInfoAluno(String matricula, String atributo) {
		return sr.findByRegistry(matricula).toString();
	}
	@Transactional
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Student entity = sr.findByRegistry(matricula);
		entity.setTutelagem(true);
		entity.setClass(disciplina);
		entity.setMastery(proficiencia);
		sr.save(entity);
	}
	 @Transactional
	 public String recuperaTutor(String matricula) {
		 return recuperaAluno(matricula);
	 }
	 @Transactional
	 public String listarTutores() {
		 RETURNS_DEEP_STUBS sr.
	 }
	 //void cadastrarHorario(String email, String horario, String dia)
	 //void cadastrarLocalDeAtendimento(String email, String local)
	 //boolean consultaHorario(String email, String horario, String dia)
	 //boolean consultaLocal(String email, String local)
	 //int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse)
	 // int pedirAjudaOnline (String matrAluno, String disciplina)
	 //String pegarTutor(int idAjuda)
	 //String getInfoAjuda(int idAjuda, String atributo)
	
}
