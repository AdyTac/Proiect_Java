package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.ActorDao;
import model.Actor;
import model.MovieProduction;




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
	public Actor find(int id) {
		return  actorDao.find(id);
	}
	


	public List<Actor> getAllUsers() {
		return actorDao.findAll();
	}
	public Actor findType(String type)throws Exception 
	{
		List<Actor> type_of = actorDao.find(type);
		System.out.println(type_of);
		Actor u = type_of.get(0);
		int idKindOf= u.getIdActor();
		System.out.println(idKindOf);
		actorDao.remove(u,idKindOf );
		return u;
	}

	

}
