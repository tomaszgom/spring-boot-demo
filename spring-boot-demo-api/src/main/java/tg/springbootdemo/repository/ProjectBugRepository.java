package tg.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tg.springbootdemo.entity.ProjectBug;

/**
 * ProjectBug Persistence Repository
 */

@Repository
public interface ProjectBugRepository extends JpaRepository<ProjectBug, Integer>{
}
