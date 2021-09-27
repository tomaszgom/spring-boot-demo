package tg.springbootdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Team Member ORM object, mapped with database, used to handle managing data
 * within application
 */

@Entity
//@Table(name="TEAM_MEMBER")
public class TeamMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // , generator="entity_seq_gen")
	@Column(name = "ID")
	private int id;

	@NotNull(message = "First Name is required")
	@Size(min = 1, max = 25, message = "First Name is required and cannot be longer than 25 characters")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotNull(message = "Last Name is required")
	@Size(min = 1, max = 25, message = "Last Name is required and cannot be longer than 25 characters")
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "POSITION")
	private String position;

	@Column(name = "POINTS")
	private Integer points;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "NOTE")
	private String note;

	// mappedBy = "projectTask" : Reference to teamMember field in ProjectTask class
	// @JoinColumn( name="TEAM_MEMBER_ID")
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teamMember", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProjectTask> projectTasks;

	public TeamMember() {
	}

	public TeamMember(String firstName, String lastName, String emailAddress, String position, Integer points,
			String phone, String note) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.position = position;
		this.points = points;
		this.phone = phone;
		this.note = note;
	}

	// Bi-directional relationship method
	public void addProjectTask(ProjectTask projectTask) {
		if (projectTasks == null) {
			projectTasks = new ArrayList<>();
		}

		projectTasks.add(projectTask);
		projectTask.setTeamMember(this); // activated after entities were joined
	}

	// Bi-directional relationship method
	public void removeProjectTask(ProjectTask projectTask) {
		if (projectTasks == null) {
			return;
		}

		projectTasks.remove(projectTask);
		projectTask.setTeamMember(this); // activated after entities were joined
	}

	public List<ProjectTask> getProjectTasks() {
		return projectTasks;
	}

	public void setProjectTasks(List<ProjectTask> projectTasksList) {
		this.projectTasks = projectTasksList;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPoints() {
		if (points == null) {
			return 0;
		} else {
			return points;
		}
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "TeamMember [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", EmailAddress="
				+ emailAddress + ", points=" + points + ", projectTasksList=" + "]";
	}
}
