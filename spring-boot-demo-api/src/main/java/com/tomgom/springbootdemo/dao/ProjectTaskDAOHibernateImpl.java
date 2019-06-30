package com.tomgom.springbootdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomgom.springbootdemo.entity.ProjectTask;

/**
 * 
 * Project Task Data Access Object implementation Repository
 * Using Native Hibernate API
 *
 */

@Repository
public class ProjectTaskDAOHibernateImpl implements ProjectTaskDAO {
	
	private EntityManager entityManager;

	@Autowired
	public ProjectTaskDAOHibernateImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<ProjectTask> getAll() {
		
		// Get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ProjectTask> theQuery = currentSession.createQuery("from Task", ProjectTask.class);
		
		List<ProjectTask> projectTasks = theQuery.getResultList();
		
		return projectTasks;
	}

}
