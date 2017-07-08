package com.scrumboard.helper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.scrumboard.domain.enumeration.TaskStatus;
import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.ChangeSet;
import com.scrumboard.domain.model.Comment;
import com.scrumboard.domain.model.Person;
import com.scrumboard.domain.model.Project;
import com.scrumboard.domain.model.Sprint;
import com.scrumboard.domain.model.Task;
import com.scrumboard.domain.model.TaskDetails;
import com.scrumboard.domain.model.TaskHistory;

import static com.scrumboard.helper.Constants.*;

public class SampleDataCreator {
	
	private static final String ANY_BACKLOG_NAME = null;
	private static final String ANY_SPRINT_NAME = null;

	private SampleDataCreator() {
		
	}
	
	public static Task createTask() {
		Task task = new Task();
		
		task.setHistory(createTaskHistory());
		
		Set<Person> persons = new HashSet<>();
		persons.add(createPerson());
		task.setResponsibles(persons);

		task.setStartedDate(LocalDateTime.now());
		task.setTaskDetails(createTaskDetails());
		task.setTaskName(ANY_TASK_NAME);
		task.setTaskId(ANY_TASK_ID);
		
		return task;
	}
	
	public static Project createProject() {

		Project project = new Project();
		
		List<Backlog> backlogList = createBacklogList();
		backlogList.get(0).setProject(project);
		
		project.setBacklogs(createBacklogList());
		project.setSprints(createSprints());

		return project;
	}

	private static List<Sprint> createSprints() {
		Sprint sprint = new Sprint();
		sprint.setSpringName(ANY_SPRINT_NAME);
		sprint.setTasks(Arrays.asList(createTask()));
		
		return Arrays.asList(sprint);
	}

	private static List<Backlog> createBacklogList() {

		Backlog backlog = new Backlog();
		backlog.addTaskToBacklog(createTask());
		backlog.setName(ANY_BACKLOG_NAME);

		return Arrays.asList(backlog);
	}

	private static TaskHistory createTaskHistory() {

		TaskHistory history = new TaskHistory();
		history.setChangeSets(createChangeSet());

		return history;
	}

	private static Set<ChangeSet> createChangeSet() {

		Set<ChangeSet> changeSets = new HashSet<>();
			
		ChangeSet changeSet = new ChangeSet();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		changeSet.setChangedDate(localDateTime);
		changeSet.setPerson(createPerson());
		changeSet.setStatus(TaskStatus.NOT_STARTED);
		changeSet.setTaskDetails(createTaskDetails());
		changeSet.setTaskName(ANY_TASK_NAME);
		
		changeSets.add(changeSet);
		
		return changeSets;
	}


	private static TaskDetails createTaskDetails() {

		TaskDetails details = new TaskDetails();
		details.setComments(createComments());
		details.setTaskDescription(ANY_TASK_DESCRIPTION);
		
		return details;
	}

	private static Set<Comment> createComments() {

		Set<Comment> comments = new HashSet<>();
		Comment comment = new Comment();
		comment.setDescription(ANY_COMMENT_DESCRIPTION);
		comment.setPerson(createPerson());
		comment.setWrittenDate(LocalDateTime.now());

		comments.add(comment);
		
		return comments;
	}

	private static Person createPerson() {
//		Set<Person> persons = new HashSet<>();
		
		Person person = new Person();
		person.setEmail(ANY_EMAIL);
		person.setPersonId(ANY_PERSON_ID);
		person.setPersonName(ANY_PERSON_NAME);

		return person;
	}
}
