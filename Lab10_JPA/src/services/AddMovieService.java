package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.AddMovieDao;
import model.Movie;

public class AddMovieService {


	private AddMovieDao addMovieDao;

	public AddMovieService() {
		try {
			addMovieDao = new AddMovieDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Movie newUser) {
		addMovieDao.create(newUser);
	}

	public void updateUser(Movie updatedUser) {
		addMovieDao.update(updatedUser);
	}
	
	public void remove(Movie user, int Id) {
		addMovieDao.remove(user, Id);
	}


	public List<Movie> getAllUsers() {
		return addMovieDao.findAll();
	}

	

}
