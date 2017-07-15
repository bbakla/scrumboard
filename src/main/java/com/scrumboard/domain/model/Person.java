package com.scrumboard.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Person.
 */
@Entity
@Table(name = "person")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    private Long id;

    @NotNull
    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "assignedTo")
    private Set<Task> tasks = new HashSet<>();
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="team_id")
    private Team team;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Task> getTasks() {
        return tasks;
    }


    public Person addTasks(Task task) {
        this.tasks.add(task);
        task.setAssignedTo(this);
        return this;
    }

    public Person removeTasks(Task task) {
        this.tasks.remove(task);
        task.setAssignedTo(null);
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    
    public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Project getPerson() {
		return project;
	}

	public void setPerson(Project project) {
		this.project = project;
	}
	
	

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        if (person.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", personName='" + getPersonName() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}
