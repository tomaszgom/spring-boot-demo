package tg.springbootdemo.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tg.springbootdemo.entity.ProjectSubTask;
import tg.springbootdemo.entity.ProjectTask;

/**
 * Repository
 * Project Task Data Access Object implementation Repository
 * Using Native Hibernate API
 */

@Repository
public class ProjectTaskRepositoryHibernImpl implements ProjectTaskRepository {
	
	private EntityManager entityManager;

	@Autowired
	public ProjectTaskRepositoryHibernImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<ProjectTask> findAll() {
		
		/* Get current Hibernate session */
		Session currentSession = entityManager.unwrap(Session.class);		
		Query<ProjectTask> theQuery = currentSession.createQuery("from ProjectTask", ProjectTask.class);
		List<ProjectTask> projectTasks = theQuery.getResultList();
		return projectTasks;
	}

	@Override
	public Optional<ProjectTask> findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		ProjectTask theProjectTask = currentSession.get(ProjectTask.class, theId);
		Optional<ProjectTask> optTheProjectTask = Optional.of(theProjectTask);
		return optTheProjectTask;
	}

	@Override
	public void saveTask(ProjectTask theProjectTask) {
		Session currentSession = entityManager.unwrap(Session.class);	
		currentSession.saveOrUpdate(theProjectTask);		
	}

	@Override
	public void deleteTaskById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		/* persistentInstance of Project Task */
		ProjectTask theProjectTask = currentSession.load(ProjectTask.class, theId);
		if (theProjectTask != null) {
			currentSession.delete(theProjectTask);
		}
	}
	
	@Override
	public List<ProjectSubTask> findAllByProjectTask(ProjectTask projectTask) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ProjectSubTask> theQuery = null;
        theQuery = currentSession.createQuery("from ProjectSubTask where projectTask=:theProjectTask", ProjectSubTask.class);
    	theQuery.setParameter("theProjectTask", projectTask);

        List<ProjectSubTask> projectSubTasksResult = theQuery.getResultList();    
         return projectSubTasksResult;		
	}
}
