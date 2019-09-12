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

import tg.springbootdemo.entity.ProjectBug;
import tg.springbootdemo.service.ProjectBugService;

/**
 * 
 * Controller Class for Project Bugs handling resource API requests received
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/project-bugs")
public class ProjectBugController {
	
	private ProjectBugService projectBugService;
	
	@Autowired
	public ProjectBugController(ProjectBugService theProjectBugService) {		
		projectBugService = theProjectBugService;
	}

	// Return the list of Project Bugs
	@GetMapping ("/all")
	public List<ProjectBug> findAll(){
		return projectBugService.findAll();
	}
	
	// Find Project Bug by Id
	@GetMapping("/{projectBugId}")
	public ProjectBug findProjectBugById(@PathVariable int projectBugId ){
		
		Optional<ProjectBug> theProjectBug = projectBugService.findById(projectBugId);

		if(theProjectBug.isEmpty()) {
			throw new RuntimeException("Employee id not found - " + projectBugId);
		}
		return theProjectBug.get();
	}
	
	//Add new Project Bug
	@PostMapping("/new")
	public ProjectBug addProjectBug(@RequestBody ProjectBug theProjectBug,
			BindingResult bindingResult) {
		
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        
		theProjectBug.setId(0);	
		projectBugService.saveBug(theProjectBug);
		return theProjectBug;
	}
	
	// Update Project Bug
	@PutMapping("/update")
	public ProjectBug updateProjectBug(@RequestBody ProjectBug theProjectBug) {
			
		projectBugService.saveBug(theProjectBug);
		return theProjectBug;
	}
	
	@DeleteMapping("/{projectBugId}")
	public String deleteProjectBug(@PathVariable int projectBugId ){
		Optional<ProjectBug> theProjectBug = projectBugService.findById(projectBugId);

		if(theProjectBug.isEmpty()) {
			throw new RuntimeException("Project Bug id not found - " + projectBugId);
		}
		
		projectBugService.deleteBugById(projectBugId);
		return "Project Bug Id '" + theProjectBug + "' has been deleted.";
	}
	
	
	
}
