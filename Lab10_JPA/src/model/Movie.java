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

	@Column(name="movie_name")
	private String movieName;

	private String time_Length;

	private String year;

	public Movie() {
	}

	public int getIdMovie() {
		return this.idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTime_Length() {
		return this.time_Length;
	}

	public void setTime_Length(String time_Length) {
		this.time_Length = time_Length;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}