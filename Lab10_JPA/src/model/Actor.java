package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actors database table.
 * 
 */
@Entity
@Table(name="actors")
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a")
public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_authors")
	private int idAuthors;

	@Column(name="a_name")
	private String aName;

	@Column(name="a_name")
	private String aName;

	@Column(name="a_role")
	private String aRole;

	@Column(name="a_role")
	private String aRole;

	@Column(name="id_authors")
	private int idAuthors;

	public Actor() {
	}

	public int getIdAuthors() {
		return this.idAuthors;
	}

	public void setIdAuthors(int idAuthors) {
		this.idAuthors = idAuthors;
	}

	public String getAName() {
		return this.aName;
	}

	public void setAName(String aName) {
		this.aName = aName;
	}

	public String getAName() {
		return this.aName;
	}

	public void setAName(String aName) {
		this.aName = aName;
	}

	public String getARole() {
		return this.aRole;
	}

	public void setARole(String aRole) {
		this.aRole = aRole;
	}

	public String getARole() {
		return this.aRole;
	}

	public void setARole(String aRole) {
		this.aRole = aRole;
	}

	public int getIdAuthors() {
		return this.idAuthors;
	}

	public void setIdAuthors(int idAuthors) {
		this.idAuthors = idAuthors;
	}

}