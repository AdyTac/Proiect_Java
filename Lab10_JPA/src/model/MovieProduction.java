package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the movie_production database table.
 * 
 */
@Entity
@Table(name="movie_production")
@NamedQuery(name="MovieProduction.findAll", query="SELECT m FROM MovieProduction m")
public class MovieProduction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int movieId;

	private int budget;

	private String homepage;

	@Column(name="id_distribution")
	private int idDistribution;

	@Column(name="id_kind")
	private int idKind;

	private int idUser;

	private String overview;

	private String title;

	//bi-directional many-to-one association to Actor
	@ManyToOne
	@JoinColumn(name="id_actor")
	private Actor actor;

	public MovieProduction() {
	}

	public int getMovieId() {
		return this.movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getBudget() {
		return this.budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public int getIdDistribution() {
		return this.idDistribution;
	}

	public void setIdDistribution(int idDistribution) {
		this.idDistribution = idDistribution;
	}

	public int getIdKind() {
		return this.idKind;
	}

	public void setIdKind(int idKind) {
		this.idKind = idKind;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getOverview() {
		return this.overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}