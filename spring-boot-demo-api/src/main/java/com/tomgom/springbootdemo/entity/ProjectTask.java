package com.tomgom.springbootdemo.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * Project Task ORM object, mapped with database, used to handle managing data within application.
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
	
	@ManyToOne (fetch = FetchType.LAZY,
			cascade= {CascadeType.ALL,})
	@JoinColumn(name="TEAM_MEMBER_ID", nullable=false)
	private TeamMember teamMember;
		
	@Column(name="TITLE")
	private String title;
	
	@Column(name="NOTE")	
	private String note;
	
	@Column(name="STATUS")	
	private String status;
	
	@Column(name="PRIORITY")	
	private String priority;
	
	@Column(name="DEAD_LINE_DATE")
	private Date deadLineDate;
	
	public ProjectTask() {
		
	}

	public ProjectTask(String title, String note, String status, String priority, Date deadLineDate) {
		this.title = title;
		this.note = note;
		this.status = status;
		this.priority = priority;
		this.deadLineDate = deadLineDate;
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
	public int getTeamMemberID() {
		return teamMember.getId();
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return note;
	}

	public void setContent(String content) {
		this.note = content;
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
	
	public Date getDeadLineDate() {
		return deadLineDate;
	}

	public void setDeadLineDate(Date deadLineDate) {
		this.deadLineDate = deadLineDate;
	}



	
	
}
