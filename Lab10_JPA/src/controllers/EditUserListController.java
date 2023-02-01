package controllers;


import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.LoginUser;
import services.UserServices;
public class EditUserListController{
	@FXML
	private TextField nameField;
	@FXML
	private TextField userID;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField userField;
	@FXML
	private TextField passwField;
	@FXML
	private TextField emailField;
	@FXML
	private Button addUser;
	@FXML
	private Button updateuserButton;
	@FXML
	private Button  deletButton;
	@FXML
	private Button refreshTableList;
	@FXML
	private TableView<LoginUser> loginTableUsers;
	@FXML
	private TableColumn<LoginUser, Integer> idUser;
	@FXML
	private TableColumn<LoginUser, String> password;
	@FXML
	private TableColumn<LoginUser, String> user;
	@FXML
	private TableColumn<LoginUser, String> name;
	@FXML
	private TableColumn<LoginUser, String> firstName;
	@FXML
	private TableColumn<LoginUser, String> email;
	Integer index;
	
	@FXML
	void initialize() {
		UserServices userService = new UserServices();
		List<LoginUser> allUsers = userService.getAllUsers();
	
        ObservableList<LoginUser> listOffusers= FXCollections.observableArrayList(new ArrayList<LoginUser>(allUsers));
		
        idUser.setCellValueFactory(new PropertyValueFactory<LoginUser,Integer>("idUser"));
		user.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("user"));
		name.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("name"));
		firstName.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("firstname"));
		password.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("password"));
		email.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("email"));
		
		loginTableUsers.setItems(listOffusers);
		
		
	}
	 @FXML
	    void getItem(MouseEvent e) {
		 index = loginTableUsers.getSelectionModel().getSelectedIndex();
		 if(index==-1)
		 {
			 return;
		 }
		
		 userID.setText(idUser.getCellData(index).toString());
		 nameField.setText(name.getCellData(index).toString());
		 firstNameField.setText(firstName.getCellData(index).toString());
		 userField.setText(user.getCellData(index).toString());
		 passwField.setText(password.getCellData(index).toString());
		 emailField.setText(email.getCellData(index).toString());
	  }


	@FXML
	private void addNewUser(ActionEvent e1){
		UserServices userService = new UserServices();
		LoginUser newObj=new LoginUser();
		
		String name=nameField.getText();
		String firstName=firstNameField.getText();
		String user=userField.getText();
		String passw=passwField.getText();
		String email=emailField.getText();
		
		newObj.setName(name);
		newObj.setFirstname(firstName);
		newObj.setUser(user);
		newObj.setPassword(passw);
		newObj.setEmail(email);
		
		try {
			userService.addUser(newObj);
			System.out.println("The Information are saved !");
		 	} catch (Exception e) {
			
				e.printStackTrace();
				showAlert();
			}
		nameField.clear();
		firstNameField.clear();
		userField.clear();
		passwField.clear();
		emailField.clear();
		userID.clear();
		
	}
	@FXML
	private void updateUser(ActionEvent e2){
		UserServices userService = new UserServices();
		
		String idStr =userID.getText();
		int id = Integer.parseInt(idStr);
		
		LoginUser newObj=userService.find(id);
		System.out.println(newObj);
		
		String name=nameField.getText();
		String firstName=firstNameField.getText();
		String user=userField.getText();
		String passw=passwField.getText();
		String email=emailField.getText();
		
		newObj.setName(name);
		newObj.setFirstname(firstName);
		newObj.setUser(user);
		newObj.setPassword(passw);
    	newObj.setEmail(email);
    			try {
			userService.updateUser(newObj);
		} catch (Exception e) {
			
				e.printStackTrace();
			}
		nameField.clear();
		firstNameField.clear();
		userField.clear();
		passwField.clear();
		emailField.clear();
		userID.clear();
		
	}
	@FXML
	private void deletUser(ActionEvent e3){
		UserServices userService = new UserServices();

		String idStr =userID.getText();
		int id = Integer.parseInt(idStr);
		
		LoginUser newObj=new LoginUser();
		try {
			userService.remove(newObj, id);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		nameField.clear();
		firstNameField.clear();
		userField.clear();
		passwField.clear();
		emailField.clear();
		userID.clear();
		
		
	}
	@FXML
	private void refresList(ActionEvent e4)
	{
		UserServices userService = new UserServices();
		List<LoginUser> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
		
        ObservableList<LoginUser> listOffusers= FXCollections.observableArrayList(new ArrayList<LoginUser>(allUsers));
		
		idUser.setCellValueFactory(new PropertyValueFactory<LoginUser,Integer>("idUser"));
		user.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("user"));
		name.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("name"));
		firstName.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("firstname"));
		password.setCellValueFactory(new PropertyValueFactory<LoginUser,String>("password"));
		
		loginTableUsers.setItems(listOffusers);
		System.out.println(listOffusers);
	}
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Wrong information");
		alert.showAndWait();}
	
}
