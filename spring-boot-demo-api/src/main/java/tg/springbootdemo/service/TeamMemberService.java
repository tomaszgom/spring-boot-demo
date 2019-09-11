package tg.springbootdemo.service;

import java.util.List;

import tg.springbootdemo.entity.TeamMember;

public interface TeamMemberService {
	
	public List<TeamMember> findAll();
	
	public TeamMember findById(int theId);
	
	public TeamMember saveTeamMember(TeamMember theTeamMember);

	public void deleteTeamMemberById(int theId);

}
