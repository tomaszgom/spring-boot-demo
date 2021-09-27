package tg.springbootdemo.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tg.springbootdemo.entity.ProjectSubTask;

/**
 * @Repository
 * Project Sub Task Data Access Object implementation Repository
 * Using Native Hibernate API
 */

@Repository
public class ProjectSubTaskRepositoryHibernImpl implements ProjectSubTaskRepository {

	private EntityManager entityManager;

	@Autowired
	public ProjectSubTaskRepositoryHibernImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<ProjectSubTask> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ProjectSubTask> theQuery = currentSession.createQuery("from ProjectSubTask", ProjectSubTask.class);
		List<ProjectSubTask> projectSubTasks = theQuery.getResultList();		
		return projectSubTasks;
	}

	@Override
	public Optional<ProjectSubTask> findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		ProjectSubTask theProjectSubTask = currentSession.get(ProjectSubTask.class, theId);
		Optional<ProjectSubTask> optlTheProjectSubTask = Optional.of(theProjectSubTask);
		return optlTheProjectSubTask;
	}

	@Override
	public void saveSubTask(ProjectSubTask theProjectSubTask) {
		Session currentSession = entityManager.unwrap(Session.class);	
		currentSession.saveOrUpdate(theProjectSubTask);		
	}

	@Override
	public void deleteSubTaskById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		ProjectSubTask theProjectSubTask = currentSession.load(ProjectSubTask.class, theId);
		if (theProjectSubTask != null) {
			currentSession.delete(theProjectSubTask);
		}
	}
}









