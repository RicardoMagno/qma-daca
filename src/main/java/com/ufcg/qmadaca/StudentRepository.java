package com.ufcg.qmadaca;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findByName(String name);
	List<Student> findByTutelagem(boolean tutelagem);
	Student findByRegistry(String registry);
	Optional<Student> findById(Long id);
	Student findByRegistryOrEmail(String registry, String email);
	Student findByEmail(String email);
	Boolean existsByRegistry(String registry);
	Boolean existsByEmail(String email);
}
