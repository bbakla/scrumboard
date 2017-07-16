package com.scrumboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrumboard.domain.model.Sprint;
import com.scrumboard.domain.model.Task;

@Repository
public interface SprintRepository<T extends Sprint> extends JpaRepository<T, Long>{

	T findById(Long id);
	
}
