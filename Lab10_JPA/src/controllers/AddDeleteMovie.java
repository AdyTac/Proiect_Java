package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


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
		
		
		String movieName=movieNameField.getText();
		String yearMovie=yearNameField.getText();
		String lengthMovie=lengthMovieField.getText();
		
	/*
		newActor.setAName(name);
		newActor.setARole(roles);
		
		try {
		newActorService.addUser(newActor);
		System.out.println("The Information are saved !");
		
		} catch (Exception e) {
		    e.printStackTrace();
		}*/
		
	}
	@FXML
	private void deleteMovie(ActionEvent e2)
	{
		String movieName=deleteMovieField.getText();
		
	}
	

}
