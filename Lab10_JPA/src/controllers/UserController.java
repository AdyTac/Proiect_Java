package controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.shape.ClosePath;
import javafx.stage.Stage;
import model.LoginUser;
import services.UserServices;

import javafx.fxml.FXMLLoader;
public class UserController {
	@FXML
	public ListView<LoginUser> userListView;

	
	@FXML
	private Label myLabel;
	@FXML
	private Button loginButton;
	@FXML
	private TextField userField;
	@FXML
	private TextField passwField;
	@FXML
	private Button newRegister;
	@FXML
	private TextField registerUserField;
	@FXML
	private TextField registerPasswField;
	@FXML
	void initialize() {
		UserServices userService = new UserServices();
		List<LoginUser> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
	}
	@FXML
	private void newRegisterMet(ActionEvent event) {
	    try {
	    	
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/AddUserInterface.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Register new user for access");
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void addNewUserU(ActionEvent event) {
		UserServices userService = new UserServices();
		LoginUser new1=new LoginUser();

		String user=registerUserField.getText();
		String password=registerPasswField.getText();
		
		new1.setPassword(password);
		new1.setUser(user);
		
		try {
			userService.addUser(new1);
			System.out.println("The Information are saved !");
			registerUserField.setText("");
			registerPasswField.setText("");
			
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	@FXML
	private void LoginToApplication(ActionEvent event) {
		String loginUser=userField.getText();
		String loginPassword=passwField.getText();
		
		UserServices userService = new UserServices();
		try {
		System.out.println(userService.findUser(loginUser, loginPassword));
		Stage stageTestButton = (Stage) loginButton.getScene().getWindow();
		stageTestButton.close();
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/MainMenu.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Main Menu");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		} catch (Exception e) {
			System.out.println("Wrong user or password");
			
			e.printStackTrace();
		}
		/*
		*/
	}

	
	
	
}
