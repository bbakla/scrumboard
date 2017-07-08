package com.scrumboard.domain.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.scrumboard.domain.enumeration.TaskStatus;

/**
 * A Task.
 */
@Entity
@Table(name = "task")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "task_id", nullable = false)
    private String taskId;

    @NotNull
    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "started_date")
    private LocalDateTime startedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(unique = true)
    private TaskDetails taskDetails;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(unique = true)
    private TaskHistory history;

    @ManyToMany(mappedBy = "tasks")
    @JsonIgnore
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Person> responsibles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDateTime getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDateTime startedDate) {
        this.startedDate = startedDate;
    }

    public TaskStatus getStatus() {
        return status;
    }


    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskDetails getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(TaskDetails taskDetails) {
        this.taskDetails = taskDetails;
    }

    public TaskHistory getHistory() {
        return history;
    }

    public void setHistory(TaskHistory taskHistory) {
        this.history = taskHistory;
    }

    public Set<Person> getResponsibles() {
        return responsibles;
    }

    public Task responsibles(Set<Person> people) {
        this.responsibles = people;
        return this;
    }

    public Task addResponsibles(Person person) {
        this.responsibles.add(person);
        person.getTasks().add(this);
        return this;
    }

    public Task removeResponsibles(Person person) {
        this.responsibles.remove(person);
        person.getTasks().remove(this);
        return this;
    }

    public void setResponsibles(Set<Person> people) {
        this.responsibles = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        if (task.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + getId() +
            ", taskId='" + getTaskId() + "'" +
            ", taskName='" + getTaskName() + "'" +
            ", startedDate='" + getStartedDate() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
