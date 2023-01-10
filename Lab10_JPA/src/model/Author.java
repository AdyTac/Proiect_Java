package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the authors database table.
 * 
 */
@Entity
@Table(name="authors")
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_authors")
	private int idAuthors;

	@Column(name="a_name")
	private String aName;

	@Column(name="a_role")
	private String aRole;

	private String country;

	private int id;

	private String name;

	public Author() {
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

	public String getARole() {
		return this.aRole;
	}

	public void setARole(String aRole) {
		this.aRole = aRole;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [idAuthors=" + idAuthors + ", aName=" + aName + ", aRole=" + aRole + ", country=" + country
				+ ", id=" + id + ", name=" + name + "]";
	}
	

}