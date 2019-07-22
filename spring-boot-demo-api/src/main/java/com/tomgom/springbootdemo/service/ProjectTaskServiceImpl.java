package com.tomgom.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomgom.springbootdemo.entity.ProjectTask;
import com.tomgom.springbootdemo.repository.ProjectTaskRepository;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

	private ProjectTaskRepository projactTaskDAO;
	
	@Autowired
	public ProjectTaskServiceImpl(ProjectTaskRepository theProjactTaskDAO) {
		projactTaskDAO = theProjactTaskDAO;
	}
	
	
	@Override
	@Transactional
	public List<ProjectTask> getAll() {
		return projactTaskDAO.getAll();
	}

	@Override
	@Transactional
	public ProjectTask searchById(int theId) {
		return projactTaskDAO.searchById(theId);
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

}
