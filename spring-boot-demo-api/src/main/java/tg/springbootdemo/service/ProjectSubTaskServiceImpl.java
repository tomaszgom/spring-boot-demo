package tg.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tg.springbootdemo.entity.ProjectSubTask;
import tg.springbootdemo.repository.ProjectSubTaskRepository;

/**
 * 
 * Service layer for handling ProjectSubTask actions
 *
 */

@Service
public class ProjectSubTaskServiceImpl implements ProjectSubTaskService {

	private ProjectSubTaskRepository projectSubTaskDAO;
	
	@Autowired
	public ProjectSubTaskServiceImpl(ProjectSubTaskRepository theProjectSubTaskDAO) {
		projectSubTaskDAO = theProjectSubTaskDAO;
	}
	
	
	@Override
	@Transactional
	public List<ProjectSubTask> findAll() {
		return projectSubTaskDAO.findAll();
	}

	@Override
	@Transactional
	public ProjectSubTask findById(int theId) {
		
		Optional<ProjectSubTask> projectSubTask = projectSubTaskDAO.findById(theId);		
		if (projectSubTask.isPresent()) {
			return projectSubTask.get();        
		} else {
			throw new EntityNotFoundException();
		}

	}

	@Override
	@Transactional
	public void saveTask(ProjectSubTask theProjectSubTask) {
		projectSubTaskDAO.saveSubTask(theProjectSubTask);

	}

	@Override
	@Transactional
	public void deleteTaskById(int theId) {
		projectSubTaskDAO.deleteSubTaskById(theId);

	}
	

}
