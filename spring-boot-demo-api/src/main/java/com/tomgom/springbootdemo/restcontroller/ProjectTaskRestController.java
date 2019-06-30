package com.tomgom.springbootdemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomgom.springbootdemo.dao.ProjectTaskDAO;
import com.tomgom.springbootdemo.entity.ProjectTask;

@RestController
@RequestMapping("/api")
public class ProjectTaskRestController {
	
	private ProjectTaskDAO projectTaskDAO;
	
	@Autowired
	public ProjectTaskRestController(ProjectTaskDAO theProjectTaskDAO) {		
		projectTaskDAO = theProjectTaskDAO;
	}

	@GetMapping ("/project-tasks")
	public List<ProjectTask> getAll(){
		return projectTaskDAO.getAll();
	}
	
}
