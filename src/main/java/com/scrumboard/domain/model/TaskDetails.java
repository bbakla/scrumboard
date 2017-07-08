package com.scrumboard.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A TaskDetails.
 */
@Entity
@Table(name = "task_details")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TaskDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_description")
    private String taskDescription;

    @OneToMany(mappedBy = "taskDetails")
    @JsonIgnore
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Comment> comments = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public TaskDetails taskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
        return this;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public TaskDetails comments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public TaskDetails addComments(Comment comment) {
        this.comments.add(comment);
        return this;
    }

    public TaskDetails removeComments(Comment comment) {
        this.comments.remove(comment);
        return this;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskDetails taskDetails = (TaskDetails) o;
        if (taskDetails.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), taskDetails.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TaskDetails{" +
            "id=" + getId() +
            ", taskDescription='" + getTaskDescription() + "'" +
            "}";
    }
}
