package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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


}
