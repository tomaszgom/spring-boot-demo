package com.tomgom.springbootdemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomgom.springbootdemo.entity.ProjectTask;
import com.tomgom.springbootdemo.repository.ProjectTaskRepository;
import com.tomgom.springbootdemo.service.ProjectTaskService;

@RestController
@RequestMapping("/api")
public class ProjectTaskRestController {
	
	private ProjectTaskService projectTaskService;
	
	@Autowired
	public ProjectTaskRestController(ProjectTaskService theProjectTaskService) {		
		projectTaskService = theProjectTaskService;
	}

	// Return the list of Project Tasks
	@GetMapping ("/project-tasks")
	public List<ProjectTask> getAll(){
		return projectTaskService.getAll();
	}
	
	@GetMapping("/project-tasks/{projectTaskId}")
	public ProjectTask getProjectTask(@PathVariable int projectTaskId ){
		ProjectTask theProjectTask = projectTaskService.searchById(projectTaskId);

		if(theProjectTask == null) {
			throw new RuntimeException("Employee id not found - " + projectTaskId);
		}
		return theProjectTask;
	}
	
	//Add new Project Task
	@PostMapping("/project-tasks")
	public ProjectTask addProjectTask(@RequestBody ProjectTask theProjectTask) {
		
		theProjectTask.setId(0);	
		projectTaskService.saveTask(theProjectTask);
		return theProjectTask;
	}
	
	// Update Project Task
	@PutMapping("/project-tasks")
	public ProjectTask updateProjectTask(@RequestBody ProjectTask theProjectTask) {
			
		projectTaskService.saveTask(theProjectTask);
		return theProjectTask;
	}
	
	@DeleteMapping("/project-tasks/{projectTaskId}")
	public String deleteProjectTask(@PathVariable int projectTaskId ){
		ProjectTask theProjectTask = projectTaskService.searchById(projectTaskId);

		if(theProjectTask == null) {
			throw new RuntimeException("Employee id not found - " + projectTaskId);
		}
		
		projectTaskService.deleteTaskById(projectTaskId);
		return "Project Task Id '" + theProjectTask + "' has been deleted.";
	}
	
	
	
	@GetMapping ("/test")
	public String getTestString(){
		return "Test was successful!";
	}
	
}
