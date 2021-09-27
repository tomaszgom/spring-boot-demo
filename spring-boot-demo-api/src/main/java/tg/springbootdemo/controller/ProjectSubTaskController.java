package tg.springbootdemo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tg.springbootdemo.entity.ProjectSubTask;
import tg.springbootdemo.service.ProjectSubTaskService;
import tg.springbootdemo.service.ProjectTaskService;

import javax.validation.ValidationException;
import java.util.List;

/**
 * Controller Class handling resource API requests received
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/project-subtasks")
public class ProjectSubTaskController {

		private ProjectTaskService projectTaskService;
		private ProjectSubTaskService projectSubTaskService;

	    public ProjectSubTaskController(ProjectTaskService theProjectTaskService, ProjectSubTaskService theProjectSubTaskService ) {
	        projectTaskService = theProjectTaskService;
	        projectSubTaskService = theProjectSubTaskService;
	    }

	    @GetMapping("/all")
	    public List<ProjectSubTask> findAll() {	
	    	return projectSubTaskService.findAll();
	    }

	    @GetMapping("/byId/{id}")
	    public ProjectSubTask findById(@PathVariable Integer projectSubTaskId) {
	    	
	    	ProjectSubTask projectSubTask = projectSubTaskService.findById(projectSubTaskId);
	        return projectSubTask;        

	    }

	    @GetMapping("/byProjectTask/{projectTaskId}")
	    public List<ProjectSubTask> findByProjectTask(@PathVariable int projectTaskId) {
	    	return projectTaskService.findAllByProjectTask(projectTaskId);	        
	    }

	    // Save SubTask
	    @PostMapping
	    public ProjectSubTask save(@RequestBody ProjectSubTask projectSubTask, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            throw new ValidationException();
	        }
	        this.projectSubTaskService.saveTask(projectSubTask);
	        return projectSubTask;
	    }

	    @DeleteMapping("/{subTaskId}")
	    public void delete(@PathVariable int subTaskId) {
	        this.projectSubTaskService.deleteTaskById(subTaskId);  
	    }
	}
