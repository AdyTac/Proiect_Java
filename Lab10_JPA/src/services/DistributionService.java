package services;

import java.util.List;
import javax.persistence.Persistence;
import dao.DistributionDao;
import model.Distribution;
import model.LoginUser;

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
	
	public void remove(Distribution user, int id) {
		addDistribDao.remove(user, id);
	}
	public Distribution find(int id) {
		return  addDistribDao.find(id);
	}


	public List<Distribution> getAllUsers() {
		return addDistribDao.findAll();
	}

	

}
