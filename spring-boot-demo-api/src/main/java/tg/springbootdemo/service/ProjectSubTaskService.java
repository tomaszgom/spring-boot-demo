package tg.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import tg.springbootdemo.entity.ProjectSubTask;

/**
 * 
 * Service Interface defining the methods and interactions
 *
 */

public interface ProjectSubTaskService {
	
	public List<ProjectSubTask> findAll();
	
	public ProjectSubTask findById(int theId);
	
	public void saveTask(ProjectSubTask theProjectSubTask);

	public void deleteTaskById(int theId);

}
