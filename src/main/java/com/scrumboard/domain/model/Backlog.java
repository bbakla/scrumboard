package com.scrumboard.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "backlog")
public class Backlog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@ElementCollection(targetClass= Task.class, fetch=FetchType.EAGER)
	@CollectionTable(name="backlog_tasks", joinColumns=@JoinColumn(name="backlog_task_id"))
	private Map<Long, Task> tasks = new TreeMap<>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="backlog")
	private List<Sprint> sprints = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;

	public void addTaskToBacklog(Task task) {
		tasks.put(task.getId(), task);
	}
	
	public void removeTaskFromBacklog(Task task) {
		tasks.remove(task.getId(), task);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Long, Task> getBacklog() {
		return tasks;
	}

	public void setBacklog(Map<Long, Task> backlog) {
		this.tasks = backlog;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Map<Long, Task> getTasks() {
		return tasks;
	}

	public void setTasks(Map<Long, Task> tasks) {
		this.tasks = tasks;
	}
	
	public void addSprint(Sprint sprint) {
		sprints.add(sprint);
	}
	
	public void removeSpring(Sprint sprint) {
		sprints.remove(sprint);
	}
	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

}
