package com.RezaAk.web.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.RezaAk.web.DojoOverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
}