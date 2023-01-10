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
	
	public void remove(LoginUser user, int Id) {
		userDao.remove(user, Id);
	}


	public List<LoginUser> getAllUsers() {
		return userDao.findAll();
	}

	/// for login
		public LoginUser findUser(String user, String pass) throws Exception {
			List<LoginUser> users = userDao.find(user);
			if (users.size() == 0) {
				throw new Exception("User not found!");
			}
			LoginUser u = users.get(0);

			if (pass.compareTo(u.getPassword()) != 0) {
				throw new Exception("Password does not match");
			}
			return u;
		}

}
