package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kind_of_movie database table.
 * 
 */
@Entity
@Table(name="kind_of_movie")
@NamedQuery(name="KindOfMovie.findAll", query="SELECT k FROM KindOfMovie k")
public class KindOfMovie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_kind")
	private int idKind;

	private String type_of;

	public KindOfMovie() {
	}

	public int getIdKind() {
		return this.idKind;
	}

	public void setIdKind(int idKind) {
		this.idKind = idKind;
	}

	public String getType_of() {
		return this.type_of;
	}

	public void setType_of(String type_of) {
		this.type_of = type_of;
	}

	@Override
	public String toString() {
		return "KindOfMovie [idKind=" + idKind + ", type_of=" + type_of + "]";
	}

	
	

}