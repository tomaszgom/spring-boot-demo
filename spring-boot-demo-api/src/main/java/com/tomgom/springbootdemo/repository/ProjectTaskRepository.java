package com.tomgom.springbootdemo.repository;

import java.util.List;

import com.tomgom.springbootdemo.entity.ProjectTask;

public interface ProjectTaskRepository {
	
	public List<ProjectTask> getAll();
	
	public ProjectTask searchById(int theId);
	
	public void saveTask(ProjectTask theProjectTask);

	public void deleteTaskById(int theId);
}
