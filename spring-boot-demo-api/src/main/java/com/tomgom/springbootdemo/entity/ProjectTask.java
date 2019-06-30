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
 * Project Task ORM object, mapped with database, used to handle managing data within application
 *
 */

@Entity
@Table(name="task")
public class ProjectTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entity_seq_gen")
	@SequenceGenerator(name="entity_seq_gen", sequenceName="hr.TASK_SEQ")
	@Column(name="ID")
	private int id;
		
	@Column(name="Title")
	private String title;
	
	@Column(name="content")	
	private String content;
	
	public ProjectTask() {
		
	}

	public ProjectTask(String title, String content) {
		this.title = title;
		this.content = content;
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
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

	
	
}
