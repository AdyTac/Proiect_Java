package controllers;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Movie;
import services.AddMovieService;

public class AddDeleteMovie {

	@FXML
	private Button addNewMovieButton;
	@FXML
	private TextField movieNameField;
	@FXML
	private TextField yearNameField;
	@FXML
	private TextField lengthMovieField;
	@FXML
	private Button deleteMovieButton;
	@FXML
	private TextField deleteMovieField;
	
	@FXML
	private void addNewMovie(ActionEvent e1)
	{
		AddMovieService newMovie=new AddMovieService();
		Movie newMovi1=new Movie();
		
		String movieName=movieNameField.getText();
		String yearMovie=yearNameField.getText();
		String lengthMovie=lengthMovieField.getText();
		
			
		newMovi1.setYear(yearMovie);
			
		newMovi1.setMovieName(movieName);
		newMovi1.setTime_Length(lengthMovie);
		
		try {
		newMovie.addUser(newMovi1);
		System.out.println("The new Movie is saved!");
		movieNameField.setText("");
		yearNameField.setText("");
		lengthMovieField.setText("");
		
		} catch (Exception e) {
		    e.printStackTrace();
		}	
	}
	@FXML
	private void deleteMovie(ActionEvent e2)
	{
		String movieName=deleteMovieField.getText();
		
	}
	

}
