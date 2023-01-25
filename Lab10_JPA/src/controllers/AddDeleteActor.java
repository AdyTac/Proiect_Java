package controllers;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Actor;
import services.ActorService;



public class AddDeleteActor {
	@FXML
	private Button addNewActorButton;
	@FXML
	private TextField nameField;
	@FXML
	private TextField nameFirstField;
	@FXML
	private TextField rolesField;
	@FXML
	private Button deleteActorButton;
	@FXML
	private TextField deleteActorField;

	
	@FXML
	private void addNewActor(ActionEvent e1)
	{
		ActorService  newActorService= new ActorService();
		Actor newActor=new Actor();
		
		String name=nameField.getText();
		String firstname=nameFirstField.getText();
		String roles=rolesField.getText();
	
		newActor.setActorName(name);
		newActor.setActorFirstName(firstname);
		newActor.setActorRole(roles);
		
		try {
		newActorService.addUser(newActor);
		System.out.println("The Information are saved !");
		nameField.setText("");
		rolesField.setText("");
		nameFirstField.setText("");
		
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	@FXML
	private void deleteActor(ActionEvent e2)
	{
		String actorName=deleteActorField.getText();
		ActorService newObj= new ActorService();
		
		try {
			newObj.findType(actorName);
		} catch (Exception e) {
			showAlert();
		}
		deleteActorField.setText(" ");

	}
	
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Please write a name in the textBox !");
		alert.showAndWait();
	}
}
