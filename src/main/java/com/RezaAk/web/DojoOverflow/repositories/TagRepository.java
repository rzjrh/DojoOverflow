package com.RezaAk.web.DojoOverflow.repositories;

import java.util.List;

import javax.servlet.jsp.tagext.Tag;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	
}