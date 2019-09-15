package com.RezaAk.web.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.RezaAk.web.DojoOverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
	
}