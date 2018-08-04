package com.ufcg.qmadaca;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
	//List<Student> findByName(String name);
	//List<Student> findByTutelagem(boolean tutelagem);
	List<Student> findAll();
	Student findByMatricula(String matricula);
	Optional<Student> findById(Long id);
	Student findByMatriculaOrEmail(String matricula, String email);
	Student findByEmail(String email);
	Boolean existsByMatricula(String matricula);
	Boolean existsByEmail(String email);
}
