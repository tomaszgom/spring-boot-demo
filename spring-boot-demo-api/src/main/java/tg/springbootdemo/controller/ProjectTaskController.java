package tg.springbootdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tg.springbootdemo.entity.ProjectTask;
import tg.springbootdemo.service.ProjectTaskService;

/**
 * 
 * Controller Class handling resource API requests received
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/project-tasks")
public class ProjectTaskController {
	
	private ProjectTaskService projectTaskService;
	
	@Autowired
	public ProjectTaskController(ProjectTaskService theProjectTaskService) {		
		projectTaskService = theProjectTaskService;
	}

	// Return the list of Project Tasks
	@GetMapping ("/all")
	public List<ProjectTask> findAll(){
		return projectTaskService.findAll();
	}
	
	// Find Project Task by Id
	@GetMapping("/{projectTaskId}")
	public ProjectTask findProjectTaskById(@PathVariable int projectTaskId ){
		
		Optional<ProjectTask> theProjectTask = projectTaskService.findById(projectTaskId);

		if(theProjectTask.isEmpty()) {
			throw new RuntimeException("Employee id not found - " + projectTaskId);
		}
		return theProjectTask.get();
	}
	
	//Add new Project Task
	@PostMapping("/new")
	public ProjectTask addProjectTask(@RequestBody ProjectTask theProjectTask,
			BindingResult bindingResult) {
		
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        
		theProjectTask.setId(0);	
		projectTaskService.saveTask(theProjectTask);
		return theProjectTask;
	}
	
	// Update Project Task
	@PutMapping("/update")
	public ProjectTask updateProjectTask(@RequestBody ProjectTask theProjectTask) {
			
		projectTaskService.saveTask(theProjectTask);
		return theProjectTask;
	}
	
	@DeleteMapping("/{projectTaskId}")
	public String deleteProjectTask(@PathVariable int projectTaskId ){
		Optional<ProjectTask> theProjectTask = projectTaskService.findById(projectTaskId);

		if(theProjectTask.isEmpty()) {
			throw new RuntimeException("Project Task id not found - " + projectTaskId);
		}
		
		projectTaskService.deleteTaskById(projectTaskId);
		return "Project Task Id '" + theProjectTask + "' has been deleted.";
	}
	
	
	
	@GetMapping ("/test")
	public String getTestString(){
		return "Test was successful!";
	}
	
}
