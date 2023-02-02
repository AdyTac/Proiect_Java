package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Customer;

public class CustomerDao  extends Dao<Customer>{


	private EntityManagerFactory factory;

	public CustomerDao(EntityManagerFactory factory) {
		super(Customer.class);
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
	
	public List<Customer> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> q = cb.createQuery(Customer.class);

		Root<Customer> c = q.from(Customer.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("actorName"), paramName));
		TypedQuery<Customer> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Customer> results = query.getResultList();
		return results;

	}
}



