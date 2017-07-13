package com.scrumboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.Team;

@Repository
public interface TeamRepository<T extends Team> extends JpaRepository<T, Long>{

	T findById(Long id);
	
}
