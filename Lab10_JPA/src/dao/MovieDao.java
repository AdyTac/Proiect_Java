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
import model.LoginUser;


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

	public List<KinfOfMovie> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<KinfOfMovie> cr = cb.createQuery(KinfOfMovie.class);
		
		Root<KinfOfMovie> root = cr.from(KinfOfMovie.class);
		
		ParameterExpression<String> paramName = cb.parameter(String.class);
	//	cr.select(root).where(cb.like(root.get("type_of"), name));
		cr.select(root).where(cb.equal(root.get("type_of"), paramName));
		TypedQuery<KinfOfMovie> query = em.createQuery(cr);
		query.setParameter(paramName, name);
		
		List<KinfOfMovie> results = query.getResultList();
		return results;
	}
	
}

	


	

