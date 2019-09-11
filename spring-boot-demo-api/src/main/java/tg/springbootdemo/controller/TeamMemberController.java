package tg.springbootdemo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tg.springbootdemo.entity.TeamMember;
import tg.springbootdemo.service.TeamMemberService;

/**
 * 
 * Team Member Entity Controller exposed end points to work with front end requests
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TeamMemberController {
	
	private TeamMemberService teamMemberService;
	
	@Autowired
	public TeamMemberController(TeamMemberService theTeamMemberService) {		
		teamMemberService = theTeamMemberService;
	}

	// Return the list of Team Members Request
	@GetMapping ("/team-members")
	public List<TeamMember> getAll(){
		return teamMemberService.findAll();
	}
	
	// Create new Team Member Request
	@PostMapping("/team-members")
	public ResponseEntity<Void> addTeamMember(@RequestBody TeamMember theTeamMember) {
		
		theTeamMember.setId(0);	
		TeamMember createdTeamMember = teamMemberService.saveTeamMember(theTeamMember);
		
		// Taking current request path, the url of created resource, appending id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(createdTeamMember.getId()).toUri();
		
		// Returning status call created, location of created resource
		return  ResponseEntity.created(uri).build();
	}
	
	// Delete Team Member
	@DeleteMapping("/team-member/{TeamMemberId}")
	public ResponseEntity<Void> deleteTeamMember(@PathVariable int teamMemberId ){
				
		 teamMemberService.deleteTeamMemberById(teamMemberId);
			 return ResponseEntity.noContent().build();
	}
		
	@GetMapping ("/team-member/test")
	public String getTestString(){
		return "Test was successful!";
	}
	
}
