package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.MovieDao;
import model.KinfOfMovie;

public class MovieService {
	private MovieDao movieDao;

	public MovieService() {
		try {
			movieDao = new MovieDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(KinfOfMovie newUser) {
		movieDao.create(newUser);
	}

	public void updateUser(KinfOfMovie updatedUser) {
		movieDao.update(updatedUser);
	}
	
	public void remove(KinfOfMovie user, int Id) {
		movieDao.remove(user, Id);
	}


	public List<KinfOfMovie> getAllUsers() {
		return movieDao.findAll();
	}

	

}
