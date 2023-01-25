package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.MovieDao;
import model.KindOfMovie;

public class MovieService {
	private MovieDao movieDao;

	public MovieService() {
		try {
			movieDao = new MovieDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(KindOfMovie newUser) {
		movieDao.create(newUser);
	}

	public void updateUser(KindOfMovie updatedUser) {
		movieDao.update(updatedUser);
	}
	
	public void remove(KindOfMovie user, int Id) {
		movieDao.remove(user, Id);
	}


	public List<KindOfMovie> getAllUsers() {
		return movieDao.findAll();
	}
	
	public KindOfMovie findType(String type)throws Exception 
	{
		List<KindOfMovie> type_of = movieDao.find(type);
		KindOfMovie u = type_of.get(0);
		int idKindOf= u.getIdKind();
		System.out.println(idKindOf);
	//	movieDao.remove(u,idKindOf );
		return u;
	}
	
}
	
	
	
	


