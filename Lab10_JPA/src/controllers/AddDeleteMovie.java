package controllers;




import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.MovieProduction;
import services.AddMovieService;


public class AddDeleteMovie {

	@FXML
	private Button addNewMovieButton;
	@FXML
	private TextField movieNameField;
	@FXML
	private TextField bugetTextField; 
	@FXML
	private TextField homePageField;
	@FXML
	private TextField ratingField;
	@FXML
	private TextField runTimeField;
	@FXML
	private Button deleteMovieButton;
	@FXML
	private TextField deleteMovieField;
	 @FXML
	private DatePicker myDatePicker;

	
	@FXML
	private void addNewMovie(ActionEvent e1)
	{
		AddMovieService newMovie=new AddMovieService();
		MovieProduction newMovi1=new MovieProduction();
		
		String title=movieNameField.getText();
		String buget=bugetTextField.getText();
		int bugget = Integer.parseInt(buget);    //convert string to int 
		String homePage=homePageField.getText();
		LocalDate myDate = myDatePicker.getValue();
		String rating =ratingField.getText();
		int ratting= Integer.parseInt(rating); 
		String runTime=runTimeField.getText();
		int runttime =Integer.parseInt(runTime);
		
		/*	
		newMovi1.setYear(yearMovie);
			
		newMovi1.setMovieName(movieName);
		newMovi1.setTime_Length(lengthMovie);
		*/
		try {
		newMovie.addUser(newMovi1);
		System.out.println("The new Movie is saved!");
		movieNameField.setText("");
		bugetTextField.setText(" ");
		homePageField.setText(" ");
		ratingField.setText(" ");
		runTimeField.setText(" ");
		
		runTimeField.setText("");
		
		} catch (Exception e) {
		    e.printStackTrace();
		    showAlert();
		}	
	}
	@FXML
	private void deleteMovie(ActionEvent e2)
	{

		String remName= deleteMovieField.getText();
		AddMovieService newObj =new AddMovieService();
		try {
		newObj.findType(remName);
		System.out.println(remName);
	 	} catch (Exception e) {
		
			e.printStackTrace();
			showAlert();
		}
		deleteMovieField.setText(" ");
		
	}
	
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Please write a name in the textBox !");
		alert.showAndWait();
	}
	

}
