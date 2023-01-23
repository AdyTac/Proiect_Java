package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.ActorDao;
import model.Actors;
import model.KinfOfMovie;



public class ActorService {
	private ActorDao actorDao;

	public ActorService() {
		try {
			actorDao = new ActorDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Actors newUser) {
		actorDao.create(newUser);
	}

	public void updateUser(Actors updatedUser) {
		actorDao.update(updatedUser);
	}
	
	public void remove(Actors user, int Id) {
		actorDao.remove(user, Id);
	}


	public List<Actors> getAllUsers() {
		return actorDao.findAll();
	}
	public Actors findType(String type)throws Exception 
	{
		List<Actors> type_of = actorDao.find(type);
		Actors u = type_of.get(0);
		int idKindOf= u.getIdActor();
		System.out.println(idKindOf);
		//actorDao.remove(u,idKindOf );
		return u;
	}

	

}
