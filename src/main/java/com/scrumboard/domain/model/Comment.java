package com.scrumboard.domain.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @Column
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    private TaskDetails taskDetails;

    @OneToOne
    @JoinColumn(unique = true)
    private Person author;

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

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person person) {
        this.author = person;
    }
    
    public TaskDetails getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(TaskDetails taskDetails) {
		this.taskDetails = taskDetails;
	}
	
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
