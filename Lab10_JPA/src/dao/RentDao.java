package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import model.Rentdata;

public class RentDao extends Dao<Rentdata>{


	private EntityManagerFactory factory;

	public RentDao(EntityManagerFactory factory) {
		super(Rentdata.class);
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
	
	public List<Rentdata> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Rentdata> q = cb.createQuery(Rentdata.class);

		Root<Rentdata> c = q.from(Rentdata.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Rentdata> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Rentdata> results = query.getResultList();
		return results;

	}
}



