package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.ActorDao;
import model.Actor;


public class ActorService {
	private ActorDao actorDao;

	public ActorService() {
		try {
			actorDao = new ActorDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Actor newUser) {
		actorDao.create(newUser);
	}

	public void updateUser(Actor updatedUser) {
		actorDao.update(updatedUser);
	}
	
	public void remove(Actor user, int Id) {
		actorDao.remove(user, Id);
	}


	public List<Actor> getAllUsers() {
		return actorDao.findAll();
	}

	

}
