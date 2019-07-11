package com.tomgom.springbootdemo.service;

import java.util.List;

import com.tomgom.springbootdemo.entity.ProjectTask;

public interface ProjectTaskService {
	
	public List<ProjectTask> getAll();
	
	public ProjectTask searchById(int theId);
	
	public void saveTask(ProjectTask theProjectTask);

	public void deleteTaskById(int theId);

}
