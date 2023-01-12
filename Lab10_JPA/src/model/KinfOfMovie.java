package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kinf_of_movie database table.
 * 
 */
@Entity
@Table(name="kinf_of_movie")
@NamedQuery(name="KinfOfMovie.findAll", query="SELECT k FROM KinfOfMovie k")
public class KinfOfMovie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_kind")
	private int idKind;

	private String type_of;

	public KinfOfMovie() {
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
		return " "+idKind+ " - " + type_of + "";
	}
	

}