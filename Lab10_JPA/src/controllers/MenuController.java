package controllers;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.LoginUser;
import services.UserServices;

public class MenuController {
	@FXML
	public ListView<LoginUser> userListView;
	@FXML
	private Button authorButton;
	@FXML
	private Button typeOfMovieButton;
	@FXML
	private Button movieButton;
	@FXML
	private Button refreshButton;
	@FXML
	private Button newUserButton;
	

	@FXML
	void initialize() {
		UserServices userService = new UserServices();
		List<LoginUser> allUsers = userService.getAllUsers();

		System.out.println(allUsers);
		userListView.setItems(FXCollections.observableArrayList(new ArrayList<LoginUser>(allUsers)));
	
	}

	@FXML
	private void refreshList(ActionEvent e) {
		UserServices userService = new UserServices();
		List<LoginUser> allUsers = userService.getAllUsers();

		System.out.println(allUsers);
		userListView.setItems(FXCollections.observableArrayList(new ArrayList<LoginUser>(allUsers)));
	}
	@FXML
	private void authorInterface(ActionEvent e1) {
		
	}
	@FXML
	private void typeOfMoviInterface(ActionEvent e2) {
		
	}
	@FXML
	private void movieInterface(ActionEvent e3) {
		
	}
	@FXML
	private void newUserInterface(ActionEvent e3) {
		
	}
}
