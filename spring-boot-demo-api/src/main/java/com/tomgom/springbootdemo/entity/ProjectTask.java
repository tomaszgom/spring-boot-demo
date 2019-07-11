package com.tomgom.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Tomasz Gomoradzki
 * Project Task ORM object, mapped with database, used to handle managing data within application.
 *
 */


@Entity
@Table(name="PROJECT_TASK")
public class ProjectTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.PROJECT_TASK_SEQ")
	@Column(name="ID")
	private int id;
		
	@Column(name="TITLE")
	private String title;
	
	@Column(name="NOTE")	
	private String note;
	
	public ProjectTask() {
		
	}

	public ProjectTask(String title, String content) {
		this.title = title;
		this.note = content;
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

	public String getContent() {
		return note;
	}

	public void setContent(String content) {
		this.note = content;
	}

	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", title=" + title + ", content=" + note + "]";
	}

	
	
}
