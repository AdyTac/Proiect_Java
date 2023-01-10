package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movie")
	private int idMovie;

	private int movie_ID;

	@Column(name="movie_name")
	private String movieName;

	private String name;

	private String year;

	public Movie() {
	}

	public int getIdMovie() {
		return this.idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public int getMovie_ID() {
		return this.movie_ID;
	}

	public void setMovie_ID(int movie_ID) {
		this.movie_ID = movie_ID;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [idMovie=" + idMovie + ", movie_ID=" + movie_ID + ", movieName=" + movieName + ", name=" + name
				+ ", year=" + year + "]";
	}
	

}