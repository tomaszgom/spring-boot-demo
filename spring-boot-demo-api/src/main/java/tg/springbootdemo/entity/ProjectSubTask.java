package tg.springbootdemo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ProjectSubTask extends ProjectIssue {

	    @Id
	    private int id;
	    //private UUID id;
	    private String title;
	    private String description;
	    private String status;
	    private Date deadlineDate;

	    //@JsonIgnore
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    @ManyToOne(fetch = FetchType.LAZY, 	cascade= CascadeType.ALL)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JoinColumn(name = "PROJECT_TASK_ID", nullable=false)
	    private ProjectTask projectTask;
	

	    protected ProjectSubTask() {
	       // this.id = UUID.randomUUID();
	       // this.deadlineDate = new Date();
	    }

	    public ProjectSubTask(String title, String description, ProjectTask projectTask) {
	        this.title = title;
	        this.description = description;
	        this.projectTask = projectTask;
	    }

	    
	/*
	 * public ProjectSubTask(String id, String title, String description,
	 * ProjectTask projectTask) { this(title, description, projectTask); if (id !=
	 * null) { this.id = UUID.fromString(id); } }
	 */


	    public int getId() {
		//public UUID getId() {
	    	return id;
	    }
		public void setId(int id) {
			this.id = id;
		}
		
		public ProjectTask getProjectTask() {
			return projectTask;
		}

		public int getProjectTaskId() {
			return projectTask.getId();
			//return  Integer.toString(this.projectTask.getId());
		}

		public void setProjectTask(ProjectTask theProjectTask) {
			this.projectTask = theProjectTask;
		}

	    public String getTitle() {
	        return title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	    public Date getDeadlineDate() {
	        return deadlineDate;
	    }

	    public void setDeadlineDate(Date deadlineDate) {
	        this.deadlineDate = deadlineDate;
	    }
	}

