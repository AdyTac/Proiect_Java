package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the distribution database table.
 * 
 */
@Entity
@NamedQuery(name="Distribution.findAll", query="SELECT d FROM Distribution d")
public class Distribution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_distribution")
	private int idDistribution;

	private String director;

	private String director;

	@Column(name="id_distribution")
	private int idDistribution;

	private String scenario;

	private String scenario;

	public Distribution() {
	}

	public int getIdDistribution() {
		return this.idDistribution;
	}

	public void setIdDistribution(int idDistribution) {
		this.idDistribution = idDistribution;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getIdDistribution() {
		return this.idDistribution;
	}

	public void setIdDistribution(int idDistribution) {
		this.idDistribution = idDistribution;
	}

	public String getScenario() {
		return this.scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getScenario() {
		return this.scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

}