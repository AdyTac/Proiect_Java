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

	private int IMDB_rating;

	private String overview;

	@Column(name="release_date")
	private String releaseDate;

	private int runtime;

	private String title;

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

	public int getIMDB_rating() {
		return this.IMDB_rating;
	}

	public void setIMDB_rating(int IMDB_rating) {
		this.IMDB_rating = IMDB_rating;
	}

	public String getOverview() {
		return this.overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRuntime() {
		return this.runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "" + title +" " +", " + budget + "," + homepage
				+ ", IMDB_rating=" + IMDB_rating + ", overview=" + overview + ", releaseDate=" + releaseDate
				+ ", runtime=" + runtime +  " ";
	}
	
	

}