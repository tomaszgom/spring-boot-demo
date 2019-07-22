package com.tomgom.springbootdemo.repository;

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
public class ProjectTaskRepositoryHibernImpl implements ProjectTaskRepository {
	
	private EntityManager entityManager;

	@Autowired
	public ProjectTaskRepositoryHibernImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<ProjectTask> getAll() {
		
		// Get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ProjectTask> theQuery = currentSession.createQuery("from ProjectTask", ProjectTask.class);
		
		List<ProjectTask> projectTasks = theQuery.getResultList();
		
		return projectTasks;
	}

	@Override
	public ProjectTask searchById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		ProjectTask theProjectTask = currentSession.get(ProjectTask.class, theId);
		return theProjectTask;
	}

	@Override
	public void saveTask(ProjectTask theProjectTask) {
		Session currentSession = entityManager.unwrap(Session.class);	
		currentSession.saveOrUpdate(theProjectTask);		
	}

	@Override
	public void deleteTaskById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);		
		Query theQuery = currentSession.createNamedQuery(
				"delete from ProjectTask where id=:projectTaskId");
		theQuery.setParameter("projectTaskId", theId);
	}

}
