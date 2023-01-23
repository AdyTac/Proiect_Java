
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Actor;
import model.KinfOfMovie;

public class ActorDao extends Dao<Actor> {

		private EntityManagerFactory factory;

	public ActorDao(EntityManagerFactory factory) {
		super(Actor.class);
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
	
	public List<Actor> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cr = cb.createQuery(Actor.class);
		
		Root<Actor> root = cr.from(Actor.class);
		
		ParameterExpression<String> paramName = cb.parameter(String.class);
	//	cr.select(root).where(cb.like(root.get("type_of"), name));
		cr.select(root).where(cb.equal(root.get("type_of"), paramName));
		TypedQuery<Actor> query = em.createQuery(cr);
		query.setParameter(paramName, name);
		
		List<Actor> results = query.getResultList();
		return results;
	}


}
