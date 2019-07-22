package com.tomgom.springbootdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Team Member ORM object, mapped with database, used to handle managing data within application
 *
 */

@Entity
//@Table(name="TEAM_MEMBER")
public class TeamMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//, generator="entity_seq_gen")
	//@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.TEAM_MEMBER_SEQ")
	@Column(name="ID")
	private int id;
	
	@NotNull(message="First Name is required")
	@Size(min=1, message="First Name is required")
	@Column(name="FIRST_NAME")
	private String firstName;
		
	@NotNull(message="Last Name is required")
	@Size(min=1, message="Last Name is required")
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="TEAM")
	private String team;
	
	@Column(name="POINTS")
	private Integer points;
	
	
	@OneToMany(mappedBy="teamMember", // reference to teamMember field in ProjectTask class
				cascade= {CascadeType.ALL,},orphanRemoval = true)//@JoinColumn( name="TEAM_MEMBER_ID")

	private List<ProjectTask> projectTasksList;

	public TeamMember() {}
	
	// Bi-directional relationship method
	public void addPurchaseOrder(ProjectTask projectTask) {
		if(projectTasksList == null) {
			projectTasksList = new ArrayList<>();
		}
		
		projectTasksList.add(projectTask);
		projectTask.setTeamMember(this);
	}
	
	// Bi-directional relationship method
	public void removeProjectTask(ProjectTask projectTask) {
		if(projectTasksList == null) {
			return;
		}
		
		projectTasksList.remove(projectTask);
		projectTask.setTeamMember(this);
	}
	
	
	public List<ProjectTask> getProjectTasks(){
		return projectTasksList;
	}
	
	public void setPOrsers(List<ProjectTask> projectTasksList) {
		this.projectTasksList = projectTasksList;
	}

	public int getId() {
		return id;
	}

	public void setId(int theId) {
		this.id = theId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getPoints() {
		if(points == null) {
			return 0;
		}else{
			return points;			
		}
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "TeamMember [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", team=" + team
				+ ", points=" + points + ", projectTasksList=" + projectTasksList + "]";
	}


	
}
