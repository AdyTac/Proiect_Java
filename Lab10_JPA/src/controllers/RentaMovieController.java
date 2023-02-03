package controllers;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RentaMovieController {
	@FXML
	private Button customerButton;
	@FXML
	private Button rentButton;
	
	 @FXML
	 private void customerAccessInterface(ActionEvent e1) {
		try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/CustomerInterface.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Actor add/delete");
		stage.setResizable(false);
		stage.setScene(new Scene(root));
		stage.show();
	}   catch (IOException e) {
		e.printStackTrace();
		
	}
	}

	 @FXML
	 private void rentMovieInterface(ActionEvent e2) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/RentAMovie.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Actor add/delete");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
			
     	 } catch (IOException e) {
			e.printStackTrace();
	    }
	 }
	 
	 
	 
}


