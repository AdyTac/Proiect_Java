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

	private String actorFirstName;

	private String actorName;

	private String actorRole;

	public Actor() {
	}

	public int getIdActor() {
		return this.idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	public String getActorFirstName() {
		return this.actorFirstName;
	}

	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}

	public String getActorName() {
		return this.actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorRole() {
		return this.actorRole;
	}

	public void setActorRole(String actorRole) {
		this.actorRole = actorRole;
	}

}