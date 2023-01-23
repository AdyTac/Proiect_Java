package dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.LoginUser;

public class UserDao extends Dao<LoginUser> {

	private EntityManagerFactory factory;

	public UserDao(EntityManagerFactory factory) {
		super(LoginUser.class);
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


	public List<LoginUser> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LoginUser> q = cb.createQuery(LoginUser.class);

		Root<LoginUser> c = q.from(LoginUser.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("user"), paramName));
		TypedQuery<LoginUser> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<LoginUser> results = query.getResultList();
		return results;
	}
}
