
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;


import model.Actors;


public class ActorDao extends Dao<Actors> {

		private EntityManagerFactory factory;

	public ActorDao(EntityManagerFactory factory) {
		super(Actors.class);
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
	
	public List<Actors> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actors> q = cb.createQuery(Actors.class);

		Root<Actors> c = q.from(Actors.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("aName"), paramName));
		TypedQuery<Actors> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Actors> results = query.getResultList();
		return results;

	}
}
