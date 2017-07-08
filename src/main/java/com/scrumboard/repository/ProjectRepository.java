package com.scrumboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrumboard.domain.backlog.Project;
import com.scrumboard.domain.task.Task;

@Repository
public interface ProjectRepository<T extends Project> extends JpaRepository<T, Long>{

	T findById(Long id);
	
}
