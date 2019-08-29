package tg.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import tg.springbootdemo.entity.ProjectSubTask;

/**
 * 
 * Service Interface defining the methods and interactions
 *
 */

import tg.springbootdemo.entity.ProjectTask;

public interface ProjectTaskService {
	
	public List<ProjectTask> findAll();
	
	public Optional<ProjectTask> findById(int theId);
	
	public void saveTask(ProjectTask theProjectTask);

	public void deleteTaskById(int theId);
	
	public List<ProjectSubTask> findAllByProjectTask(int theProjectTaskId);
	
	

}
