package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rentmovie database table.
 * 
 */
@Entity
@NamedQuery(name="Rentmovie.findAll", query="SELECT r FROM Rentmovie r")
public class Rentmovie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRentMovie;

	private int idCustomer;

	@Column(name="movie_id")
	private int movieId;

	public Rentmovie() {
	}

	public int getIdRentMovie() {
		return this.idRentMovie;
	}

	public void setIdRentMovie(int idRentMovie) {
		this.idRentMovie = idRentMovie;
	}

	public int getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int getMovieId() {
		return this.movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

}