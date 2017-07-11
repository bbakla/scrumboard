package com.scrumboard.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="sprint")
public class Sprint{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String sprintName;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="sprint_tasks", joinColumns=  @JoinColumn(name="sprint_id"),
			   inverseJoinColumns= @JoinColumn(name="task_id"))
	private List<Task> tasks = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="backlog_id")
	private Backlog backlog;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String springName) {
		this.sprintName = springName;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Backlog getProject() {
		return backlog;
	}

	public void setProject(Backlog project) {
		this.backlog = project;
	}
	
	
}
