package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Movie;

public class AddMovieDao extends Dao<Movie> {

		private EntityManagerFactory factory;

	public AddMovieDao(EntityManagerFactory factory) {
		super(Movie.class);
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
