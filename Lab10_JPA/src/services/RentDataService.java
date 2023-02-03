package services;



import java.util.List;
import javax.persistence.Persistence;
import dao.RentDao;
import model.Rentdata;

public class RentDataService {
	private RentDao rentDao;

	public RentDataService() {
		try {
			rentDao = new RentDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Rentdata newUser) {
		rentDao.create(newUser);
	}

	public void updateUser(Rentdata updatedUser) {
		rentDao.update(updatedUser);
	}
	
	public void remove(Rentdata user, int id) {
		rentDao.remove(user, id);
	}
	public Rentdata find(int id) {
		return  rentDao.find(id);
	}
	public List<Rentdata> getAllUsers() {
		return rentDao.findAll();
	}
		

}
