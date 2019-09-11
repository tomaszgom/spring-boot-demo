package tg.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
public class ProjectSubTask extends ProjectIssue {

	    @Id
	    private int id;
	    //private UUID id;
	    private String title;
	    private String description;
	    private String status;
	    private Date deadlineDate;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PROJECT_TASK_ID")
	    //@JsonIgnore
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private ProjectTask projectTask;
	    

	    protected ProjectSubTask() {
	       // this.id = UUID.randomUUID();
	       // this.deadlineDate = new Date();
	    }

	    public ProjectSubTask(String title, String description, ProjectTask projectTask) {
	        this();
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

	    public String getTitle() {
	        return title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public ProjectTask getProjectTask() {
	        return projectTask;
	    }

	    public String getProjectTaskId() {
	        return  Integer.toString(this.projectTask.getId());
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

