package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Actor;
import services.ActorService;
import services.MovieService;

public class AddDeletActor {
	@FXML
	private Button loginButton;
	@FXML
	private TextField nameField;
	@FXML
	private TextField rolesField;
	
	private void addNewActor(ActionEvent event)
	{
		ActorService  newActorService= new ActorService();
		Actor newActor=new Actor();
		
		String name=nameField.getText();
		String roles=rolesField.getText();
	
		newActor.setAName(name);
		newActor.setARole(roles);
		
		try {
		newActorService.addUser(newActor);
		System.out.println("The Information are saved !");
		
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

}
