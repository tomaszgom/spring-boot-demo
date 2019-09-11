package tg.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tg.springbootdemo.entity.TeamMember;
import tg.springbootdemo.repository.TeamMemberRepository;


/**
 * 
 * Team Member Service (business logic) layer
 *
 */

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
	
	private TeamMemberRepository teamMemberRepository;
	
	
	public TeamMemberServiceImpl() {	
		
	}
	
	@Autowired
	public TeamMemberServiceImpl(TeamMemberRepository theTeamMemberRepository) {
		teamMemberRepository = theTeamMemberRepository;
	}
		
	@Override
	@Transactional
	public List<TeamMember> findAll() {
		 return teamMemberRepository.findAll();
	}

	@Override
	@Transactional
	public TeamMember findById(int theId) {
		return teamMemberRepository.findById(theId).get();
	}

	@Override
	@Transactional
	public TeamMember saveTeamMember(TeamMember theTeamMember) {
		teamMemberRepository.save(theTeamMember);
		return theTeamMember;
	}

	@Override
	@Transactional
	public void deleteTeamMemberById(int theId) {
		teamMemberRepository.deleteById(theId);
	}

}
