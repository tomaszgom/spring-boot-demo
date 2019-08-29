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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
public class ProjectTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//, generator="entity_seq_gen")
	//@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.PROJECT_TASK_SEQ")
	@Column(name="ID")
	private int id;
	
//	@ManyToOne (fetch = FetchType.LAZY,
//			cascade= {CascadeType.ALL,})
//	@JoinColumn(name="TEAM_MEMBER_ID", nullable=false)
//	private TeamMember teamMember;
	
	
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
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectTask", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProjectSubTask> projectSubTasks;
  
	
	public ProjectTask() {	
	}

	public ProjectTask(String title, String description, String status, String priority, Date deadlineDate) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.deadlineDate = deadlineDate;
		this.projectSubTasks = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
//	public TeamMember getTeamMember() {
//		return teamMember;
//	}
//	public int getTeamMemberID() {
//		return teamMember.getId();
//	}
//
//	public void setTeamMember(TeamMember teamMember) {
//		this.teamMember = teamMember;
//	}

	
    public List<ProjectSubTask> getProjectSubTasks() {
        return projectSubTasks;
    }

    public int getNbOfProjectSubTasks() {
        return this.projectSubTasks.size();
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
