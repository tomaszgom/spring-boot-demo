package tg.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tg.springbootdemo.entity.ProjectBug;
import tg.springbootdemo.repository.ProjectBugRepository;

@Service
public class ProjectBugServiceImpl implements ProjectBugService {

	private ProjectBugRepository projactBugDAO;
	
	@Autowired
	public ProjectBugServiceImpl(ProjectBugRepository theProjactBugDAO) {
		projactBugDAO = theProjactBugDAO;
	}
	
	
	@Override
	@Transactional
	public List<ProjectBug> findAll() {
		return projactBugDAO.findAll();
	}

	@Override
	@Transactional
	public Optional<ProjectBug> findById(int theId) {
		return projactBugDAO.findById(theId);
	}

	@Override
	@Transactional
	public void saveBug(ProjectBug theProjectBug) {
		projactBugDAO.save(theProjectBug);

	}

	@Override
	@Transactional
	public void deleteBugById(int theId) {
		projactBugDAO.deleteById(theId);

	}


}
