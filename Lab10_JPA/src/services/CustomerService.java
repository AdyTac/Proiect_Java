package services;
import java.util.List;
import javax.persistence.Persistence;
import dao.CustomerDao;
import model.Customer;


public class CustomerService {
	
	private CustomerDao customDao;

	public CustomerService() {
		try {
			customDao = new CustomerDao(Persistence.createEntityManagerFactory("Lab10_JPA"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
		public void addUser(Customer newUser) {
			customDao.create(newUser);
		}

		public void updateUser(Customer updatedUser) {
			customDao.update(updatedUser);
		}
		
		public void remove(Customer user, int Id) {
			customDao.remove(user, Id);
		}
		public Customer find(int id) {
			return  customDao.find(id);
		}
		


		public List<Customer> getAllUsers() {
			return customDao.findAll();
		}
		public Customer findType(String type)throws Exception 
		{
			List<Customer> type_of = customDao.find(type);
			System.out.println(type_of);
			Customer u = type_of.get(0);
			int idKindOf= u.getIdCustomer();
			System.out.println(idKindOf);
		//	customDao.remove(u,idKindOf );
			return u;
		}

		

	}


