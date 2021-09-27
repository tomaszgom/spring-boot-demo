package tg.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tg.springbootdemo.entity.ProjectSubTask;
import tg.springbootdemo.entity.ProjectTask;
import tg.springbootdemo.repository.ProjectTaskRepository;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

	private ProjectTaskRepository projactTaskDAO;
	
	@Autowired
	public ProjectTaskServiceImpl(ProjectTaskRepository theProjactTaskDAO) {
		projactTaskDAO = theProjactTaskDAO;
	}

	@Override
	@Transactional
	public List<ProjectTask> findAll() {
		return projactTaskDAO.findAll();
	}

	@Override
	@Transactional
	public Optional<ProjectTask> findById(int theId) {
		return projactTaskDAO.findById(theId);
	}

	@Override
	@Transactional
	public void saveTask(ProjectTask theProjectTask) {
		projactTaskDAO.saveTask(theProjectTask);
	}

	@Override
	@Transactional
	public void deleteTaskById(int theId) {
		projactTaskDAO.deleteTaskById(theId);
	}

	@Override
	public List<ProjectSubTask> findAllByProjectTask(int projectTaskId) {
        List<ProjectSubTask> projectSubTasks = new ArrayList<>();
        Optional<ProjectTask> theProjectTask = this.projactTaskDAO.findById(projectTaskId);      
                
        if (theProjectTask.isPresent()) {	        	
        	projectSubTasks = projactTaskDAO.findAllByProjectTask(theProjectTask.get());	        
        }
        return projectSubTasks;
	}
}
