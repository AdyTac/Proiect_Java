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

public class DistributionDao extends Dao<Distribution> {

		private EntityManagerFactory factory;

	public DistributionDao(EntityManagerFactory factory) {
		super(Distribution.class);
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
	public List<Distribution> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Distribution> cr = cb.createQuery(Distribution.class);
		
		Root<Distribution> root = cr.from(Distribution.class);
		
		ParameterExpression<String> paramName = cb.parameter(String.class);
	//	cr.select(root).where(cb.like(root.get("type_of"), name));
		cr.select(root).where(cb.like(root.get("director"), paramName));
		TypedQuery<Distribution> query = em.createQuery(cr);
		query.setParameter(paramName, name);
		
		List<Distribution> results = query.getResultList();
		return results;
	}


}
