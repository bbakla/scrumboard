package com.scrumboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrumboard.domain.model.Project;
import com.scrumboard.domain.model.Task;

@Repository
public interface TaskRepository<T extends Task> extends JpaRepository<T, Long>{

	T findById(Long id);
	
}
