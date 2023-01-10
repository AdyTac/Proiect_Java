package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	@FXML
	private void deleteActor(ActionEvent e2)
	{
		
		
	}
	

}
