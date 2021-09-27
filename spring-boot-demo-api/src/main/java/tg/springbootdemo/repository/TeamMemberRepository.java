package tg.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tg.springbootdemo.entity.TeamMember;

/**
 * Team Member Persistence Repository
 */

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer>{
	
}
