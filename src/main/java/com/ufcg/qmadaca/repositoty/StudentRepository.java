package com.ufcg.qmadaca.repositoty;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.ufcg.qmadaca.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
	Student findByMatricula(String matricula);
	Optional<Student> findById(Long id);
	Student findByMatriculaOrEmail(String matricula, String email);
	Student findByEmail(String email);
	Boolean existsByMatricula(String matricula);
	Boolean existsByEmail(String email);
}
