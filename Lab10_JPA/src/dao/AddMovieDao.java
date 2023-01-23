package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Distribution;
import model.Movie;

public class AddMovieDao extends Dao<Movie> {

		private EntityManagerFactory factory;

	public AddMovieDao(EntityManagerFactory factory) {
		super(Movie.class);
		this.factory = factory;
	}

	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception ex) {
			System.out.println("The entity manager cannot be created!");
			return null;
		}
	}
	public List<Movie> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> cr = cb.createQuery(Movie.class);
		
		Root<Movie> root = cr.from(Movie.class);
		
		ParameterExpression<String> paramName = cb.parameter(String.class);
	//	cr.select(root).where(cb.like(root.get("type_of"), name));
		cr.select(root).where(cb.equal(root.get("type_of"), paramName));
		TypedQuery<Movie> query = em.createQuery(cr);
		query.setParameter(paramName, name);
		
		List<Movie> results = query.getResultList();
		return results;
	}


}
