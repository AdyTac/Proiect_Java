package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.AddMovieDao;
import model.MovieProduction;

public class AddMovieService {


	private AddMovieDao addMovieDao;

	public AddMovieService() {
		try {
			addMovieDao = new AddMovieDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(MovieProduction newUser) {
		addMovieDao.create(newUser);
	}

	public void updateUser(MovieProduction updatedUser) {
		addMovieDao.update(updatedUser);
	}
	
	public void remove(MovieProduction user, int Id) {
		addMovieDao.remove(user, Id);
	}

	public List<MovieProduction> getAllUsers() {
		return addMovieDao.findAll();
	}
	
	public MovieProduction findType(String type)throws Exception 
	{
		List<MovieProduction> type_of = addMovieDao.find(type);
		MovieProduction u = type_of.get(0);
		int idMovie= u.getMovieId();
		System.out.println(idMovie);
		//addMovieDao.remove(u,idMovie );
		return u;
	}
	

}
