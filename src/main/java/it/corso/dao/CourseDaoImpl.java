package it.corso.dao;

import java.util.List;
import it.corso.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CourseDaoImpl implements CustomizedCourseDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Course> findCourse(String name, int categoryId){
		String query = "SELECT *"
					 + "FROM corso"
					 + "WHERE Nome_Corso LIKE :name AND FK_CA = :id";
		
		return (List<Course>) entityManager.createQuery(query)
			    .setParameter("name", name)
			    .setParameter("id", categoryId).getResultList();
	}

}
