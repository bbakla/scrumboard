package com.scrumboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrumboard.domain.task.Task;

@Repository
public interface ScrumBoardRepository<T extends Task> extends JpaRepository<T, String>{

	T findById(Long id);
	
}
