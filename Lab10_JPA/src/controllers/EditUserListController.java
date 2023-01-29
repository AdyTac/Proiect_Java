package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.KindOfMovie;
import model.LoginUser;
import services.UserServices;

public class EditUserListController {
	@FXML
	private TextField searchUserfield;
	@FXML
	private TextField updateUserfield;
	@FXML
	private TextField deletUserfield;
	@FXML
	private Button searchButton;
	@FXML
	private Button refresUserList;
	@FXML
	public ListView<LoginUser> userViewList;
	@FXML
	private TableView<LoginUser> loginTableUsers;
	@FXML
	private TableColumn<LoginUser, String> idUser;
	@FXML
	private TableColumn<LoginUser, String> password;
	@FXML
	private TableColumn<LoginUser, String> user;
	
	@FXML
	void initialize() {
		UserServices userService = new UserServices();
		List<LoginUser> allUsers = userService.getAllUsers();
	//	System.out.println(allUsers);
	//	userViewList.setItems(FXCollections.observableArrayList(new ArrayList<LoginUser>(allUsers)));
		
		ObservableList<LoginUser> listOffusers= FXCollections.observableArrayList(new ArrayList<LoginUser>(allUsers));
		idUser.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("idUser"));
		user.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("user"));
		password.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("password"));
		loginTableUsers.setItems(listOffusers);
		System.out.println(listOffusers);

	}
	@FXML
	private void searchUser(ActionEvent e1){
		UserServices newObj =new UserServices();
		String searchUser=searchUserfield.getText();
		
		try {
			newObj.findType(searchUser);
			System.out.println(searchUser);
			showInformation();
			
		 	} catch (Exception e) {
			
				e.printStackTrace();
				showAlert();
			}
		searchUserfield.clear();
	}
	@FXML
	private void updateUser(ActionEvent e2){

	}
	@FXML
	private void deletUser(ActionEvent e3){
		UserServices newObj =new UserServices();
		String searchUser=searchUserfield.getText();
		
		try {
			newObj.findDelete(searchUser);
			showDelete() ;
			
		 	} catch (Exception e) {
			
				e.printStackTrace();
				showAlert();
			}
		deletUserfield.setText(" ");
	}
	@FXML
	private void refresList(ActionEvent e4)
	{
		UserServices userService = new UserServices();
		List<LoginUser> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
		userViewList.setItems(FXCollections.observableArrayList(new ArrayList<LoginUser>(allUsers)));
	}
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Wrong information");
		alert.showAndWait();
	}
	private void showInformation() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Search information");
		alert.setContentText("The user is in tha database");
		alert.showAndWait();
	}
	private void showDelete() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Search information");
		alert.setContentText("Tyhe user was found and delete");
		alert.showAndWait();
	}
	

}
