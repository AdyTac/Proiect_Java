package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import model.MovieProduction;

public class AddMovieDao extends Dao<MovieProduction> {

		private EntityManagerFactory factory;

	public AddMovieDao(EntityManagerFactory factory) {
		super(MovieProduction.class);
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
	public List<MovieProduction> find(String name) {
		System.out.println(name);
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MovieProduction> q = cb.createQuery(MovieProduction.class);

		Root<MovieProduction> c = q.from(MovieProduction.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("title"), paramName));
		TypedQuery<MovieProduction> query = em.createQuery(q);
		query.setParameter(paramName, name);
		System.out.println(paramName);
		List<MovieProduction> results = query.getResultList();
		return results;
		
	}


}
