package tg.springbootdemo.repository;

import java.util.List;
import java.util.Optional;

import tg.springbootdemo.entity.ProjectSubTask;

public interface ProjectSubTaskRepository {
	
	public List<ProjectSubTask> findAll();
	
	public Optional<ProjectSubTask> findById(int theId);
	
	public void saveSubTask(ProjectSubTask theProjectSubTask);

	public void deleteSubTaskById(int theId);
	
}
