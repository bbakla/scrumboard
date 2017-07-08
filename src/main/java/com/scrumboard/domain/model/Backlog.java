package com.scrumboard.domain.model;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

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
	private Map<String, Task> backlog = new TreeMap<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;

	public void addTaskToBacklog(Task task) {
		backlog.put(task.getTaskId(), task);
	}
	
	public void removeTaskFromBacklog(Task task) {
		backlog.remove(task.getId(), task);
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

	public Map<String, Task> getBacklog() {
		return backlog;
	}

	public void setBacklog(Map<String, Task> backlog) {
		this.backlog = backlog;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
