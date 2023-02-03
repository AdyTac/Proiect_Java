package services;



import java.util.List;

import javax.persistence.Persistence;
import dao.UserDao;

import model.LoginUser;

public class UserServices {
	private UserDao userDao;

	public UserServices() {
		try {
			userDao = new UserDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(LoginUser newUser) {
		userDao.create(newUser);
	}

	public void updateUser(LoginUser updatedUser) {
		userDao.update(updatedUser);
	}
	
	public void remove(LoginUser user, int id) {
		userDao.remove(user, id);
	}
	public LoginUser find(int id) {
		return  userDao.find(id);
	}
	public List<LoginUser> getAllUsers() {
		return userDao.findAll();
	}
		public LoginUser findUser(String user, String pass) throws Exception {
			List<LoginUser> users = userDao.findUsersByName(user);
			if (users.size() == 0) {
				throw new Exception("User not found!");
			}
			LoginUser u = users.get(0);

			if (pass.compareTo(u.getPassword()) != 0) {
				throw new Exception("Password does not match");
			}
			return u;
		}
		public LoginUser findType(String type)throws Exception 
		{
			List<LoginUser> userSearch=userDao.findUsersByName(type);
			LoginUser u = userSearch.get(0);
			int idKindOf= u.getIdUser();
			System.out.println(idKindOf);
			//movieDao.remove(u,idKindOf );
			return u;
		}
		public LoginUser findDelete(String type)throws Exception 
		{
			List<LoginUser> userSearch=userDao.findUsersByName(type);
			LoginUser u = userSearch.get(0);
			int idKindOf= u.getIdUser();
			System.out.println(idKindOf);
			userDao.remove(u,idKindOf );
			return u;
		}
		

}
