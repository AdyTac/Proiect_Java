package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.KinfOfMovie;


public class MovieDao extends Dao<KinfOfMovie> {

		private EntityManagerFactory factory;

	public MovieDao(EntityManagerFactory factory) {
		super(KinfOfMovie.class);
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

	// for login
	public List<KinfOfMovie> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<KinfOfMovie> q = cb.createQuery(KinfOfMovie.class);

		Root<KinfOfMovie> c = q.from(KinfOfMovie.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("user"), paramName));
		TypedQuery<KinfOfMovie> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<KinfOfMovie> results = query.getResultList();
		return results;
	}
}
