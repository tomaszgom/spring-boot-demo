package tg.springbootdemo.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * ORM object, mapped with database, used to handle managing data within application.
 * 
 * @BusinessLogic: 
 * Project Task is a part of Project, it is activity, created, assigned
 * to team member, requiring work and completion.
 *
 */


@Entity
//@Table(name="PROJECT_TASK")
public class ProjectTask extends ProjectIssue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//, generator="entity_seq_gen")
	//@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.PROJECT_TASK_SEQ")
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
	    
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectTask", cascade= CascadeType.ALL,orphanRemoval = true)
    private List<ProjectSubTask> projectSubTasks;
    
   
    //@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, 	cascade= CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "TEAM_MEMBER_ID", nullable=false)
    private TeamMember teamMember;
	
	public ProjectTask() {	
	}

	public ProjectTask(String title, String description, String status, String priority, Date deadlineDate, TeamMember theTeamMember) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.deadlineDate = deadlineDate;
		this.projectSubTasks = new ArrayList<>();
		this.teamMember = theTeamMember;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public TeamMember getTeamMember() {
		return teamMember;
	}
//	public int getTeamMemberID() {
//		return teamMember.getId();
//	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

	
    public List<ProjectSubTask> getProjectSubTasks() {
        return projectSubTasks;
    }
    
    public void setProjectSubTasks(List<ProjectSubTask> theProjectSubTasks) {
        this.projectSubTasks = theProjectSubTasks;
    }
    
	// Bi-directional relationship method
	public void addProjectSubTask(ProjectSubTask theProjectSubTask) {
		if(projectSubTasks == null) {
			projectSubTasks = new ArrayList<>();
		}		
		projectSubTasks.add(theProjectSubTask);
		theProjectSubTask.setProjectTask(this);
	}
	
	// Bi-directional relationship method
	public void removeProjectSubTask(ProjectSubTask theProjectSubTask) {
		if(projectSubTasks == null) {
			return;
		}
		projectSubTasks.remove(theProjectSubTask);
		theProjectSubTask.setProjectTask(this);
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
	
	
	
}
