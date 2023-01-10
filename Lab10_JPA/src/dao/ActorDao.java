
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Actor;

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


}
