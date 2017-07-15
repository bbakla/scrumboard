package com.scrumboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Person;
import com.scrumboard.domain.model.Project;
import com.scrumboard.repository.PersonRepository;

@Service
public class PersonRepoService {
	
	@Autowired
	private PersonRepository<Person> personRepository;
	
	public List<Person> getPeople() {
		
		return personRepository.findAll();
	}
	
	public List<Person> getPeople(Project project) {
		return personRepository.findByProject(project);
	}
	
	public void savePerson(Person person) {
		personRepository.save(person);
	}

}
