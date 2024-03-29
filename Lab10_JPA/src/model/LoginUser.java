package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login_user database table.
 * 
 */
@Entity
@Table(name="login_user")
@NamedQuery(name="LoginUser.findAll", query="SELECT l FROM LoginUser l")
public class LoginUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String email;

	private String firstname;

	private String name;

	private String password;

	private String user;

	public LoginUser() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoginUser [idUser=" + idUser + ", email=" + email + ", firstname=" + firstname + ", name=" + name
				+ ", password=" + password + ", user=" + user + "]";
	}
	


}