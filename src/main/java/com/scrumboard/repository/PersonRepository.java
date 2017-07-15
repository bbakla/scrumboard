package com.scrumboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrumboard.domain.model.Person;
import com.scrumboard.domain.model.Project;

@Repository
public interface PersonRepository<T extends Person> extends JpaRepository<T, Long>{

	T findById(Long id);
	
	List<T> findByProject(Project project);
}
