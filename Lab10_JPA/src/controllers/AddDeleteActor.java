package controllers;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import model.Actors;
import model.LoginUser;
import services.ActorService;
import services.AddMovieService;


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
		Actors newActor=new Actors();
		
		String name=nameField.getText();
		String roles=rolesField.getText();
	
		newActor.setAName(name);
		newActor.setARole(roles);
		
		try {
		newActorService.addUser(newActor);
		System.out.println("The Information are saved !");
		nameField.setText("");
		rolesField.setText("");
		
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
	@FXML
	private void deleteActor(ActionEvent e2)
	{
		String actorName=deleteActorField.getText();
		ActorService newObj= new ActorService();
		List<Actors> allUsers = newObj.getAllUsers();
		System.out.println(allUsers);
		try {
			newObj.findType(actorName);
		} catch (Exception e) {
			System.out.println("The name is not in the list !");
			e.printStackTrace();
		}
		
		
		
	}
	

}
