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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_actor")
	private int idActor;

	@Column(name="a_name")
	private String aName;

	@Column(name="a_role")
	private String aRole;

	public Actor() {
	}

	public int getIdActor() {
		return this.idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
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

	@Override
	public String toString() {
		return "Actor [idActor=" + idActor + ", aName=" + aName + ", aRole=" + aRole + "]";
	}
	

}