package tg.springbootdemo.repository;

import java.util.List;
import java.util.Optional;

import tg.springbootdemo.entity.ProjectSubTask;
import tg.springbootdemo.entity.ProjectTask;

public interface ProjectTaskRepository {
	
	public List<ProjectTask> findAll();
	
	public Optional<ProjectTask> findById(int theId);
	
	public void saveTask(ProjectTask theProjectTask);

	public void deleteTaskById(int theId);
	
	public List<ProjectSubTask> findAllByProjectTask(ProjectTask projectTask);
}
