package tg.springbootdemo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 
 * ORM object, mapped with database, used to handle managing data within application.
 * 
 * @BusinessLogic: 
 * Bug is an activity, unit of work within a Project. It is an issue which cause problems, prevents the functionality 
 * of a software product, it is activity, assigned to team member, requiring work and resolution.
 *
 */


@Entity
//@Table(name="PROJECT_BUG")
public class ProjectBug extends ProjectIssue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@NotNull
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")	
	private String description;
	
	@Column(name="STATUS")	
	private String status;
	
	@Column(name="PRIORITY")	
	private String priority;
	
	@Column(name="DEADLINE_DATE")
	private Date deadlineDate;
	
  
	public ProjectBug() {	
	}

	public ProjectBug(String title, String description, String status, String priority, Date deadlineDate) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.deadlineDate = deadlineDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public Date getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	@Override
	public String toString() {
		return "ProjectBug [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", priority=" + priority + ", deadlineDate=" + deadlineDate + "]";
	}

	
}
