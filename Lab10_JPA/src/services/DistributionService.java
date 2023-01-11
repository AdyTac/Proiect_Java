package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.DistributionDao;
import model.Distribution;

public class DistributionService {


	private DistributionDao addDistribDao;

	public DistributionService() {
		try {
			addDistribDao = new DistributionDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Distribution newUser) {
		addDistribDao.create(newUser);
	}

	public void updateUser(Distribution updatedUser) {
		addDistribDao.update(updatedUser);
	}
	
	public void remove(Distribution user, int Id) {
		addDistribDao.remove(user, Id);
	}


	public List<Distribution> getAllUsers() {
		return addDistribDao.findAll();
	}

	

}
