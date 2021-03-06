package com.scrumboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrumboard.domain.model.Backlog;

@Repository
public interface BacklogRepository<T extends Backlog> extends JpaRepository<T, Long>{

	T findById(Long id);
	
}
