package com.scrumboard.domain.task;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Comment.
 */
@Entity
@Table(name = "comment")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "taks_details_id", nullable = false)
    private String taksDetailsId;

    @NotNull
    @Column(name = "written_date", nullable = false)
    private LocalDateTime writtenDate;

    @Column(name = "description")
    private String description;
    
    @ManyToOne
    private TaskDetails taskDetails;

    @OneToOne
    @JoinColumn(unique = true)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaksDetailsId() {
        return taksDetailsId;
    }

    public void setTaksDetailsId(String taksDetailsId) {
        this.taksDetailsId = taksDetailsId;
    }

    public LocalDateTime getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(LocalDateTime writtenDate) {
        this.writtenDate = writtenDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public TaskDetails getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(TaskDetails taskDetails) {
		this.taskDetails = taskDetails;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        if (comment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), comment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Comment{" +
            "id=" + getId() +
            ", taksDetailsId='" + getTaksDetailsId() + "'" +
            ", writtenDate='" + getWrittenDate() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
