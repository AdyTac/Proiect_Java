package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import model.KindOfMovie;



public class MovieDao extends Dao<KindOfMovie> {

		private EntityManagerFactory factory;

	public MovieDao(EntityManagerFactory factory) {
		super(KindOfMovie.class);
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

	public List<KindOfMovie> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<KindOfMovie> cr = cb.createQuery(KindOfMovie.class);
		
		Root<KindOfMovie> root = cr.from(KindOfMovie.class);
		
		ParameterExpression<String> paramName = cb.parameter(String.class);
		cr.select(root).where(cb.equal(root.get("type_of"), paramName));
		TypedQuery<KindOfMovie> query = em.createQuery(cr);
		query.setParameter(paramName, name);
		
		List<KindOfMovie> results = query.getResultList();
		return results;
	}
	
}

	


	

