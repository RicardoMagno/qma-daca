package com.ufcg.qmadaca.repositoty;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ufcg.qmadaca.entity.Tutor;

public interface TutorRepository extends CrudRepository<Tutor, Long>{
	List<Tutor> findAll();
	Tutor findByMatricula(String matricula);
}