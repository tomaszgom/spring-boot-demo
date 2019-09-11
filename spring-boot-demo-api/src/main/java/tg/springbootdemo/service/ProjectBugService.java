package tg.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import tg.springbootdemo.entity.ProjectBug;

public interface ProjectBugService {
	
	public List<ProjectBug> findAll();
	
	public Optional<ProjectBug> findById(int theId);
	
	public void saveBug(ProjectBug theProjectBug);

	public void deleteBugById(int theId);

}
