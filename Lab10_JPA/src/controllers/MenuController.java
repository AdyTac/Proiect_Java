package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.LoginUser;
import services.MovieService;
import services.UserServices;
import model.KinfOfMovie;


public class MenuController {
	@FXML
	public ListView<LoginUser> userListView;
	@FXML
	private Button actorButton;
	@FXML
	private Button typeOfMovieButton;
	@FXML
	private Button movieButton;
	@FXML
	private Button refreshButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button distributionButton;
	@FXML
	private TextField newTypeOf;
	

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
	private void actorInterface(ActionEvent e1) {
try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/AddActor.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Actor add/delete");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	private void typeOfMoviInterface(ActionEvent e2) {
		MovieService  newTypee= new MovieService();
		KinfOfMovie newTypeof= new KinfOfMovie();
		
		String newType=newTypeOf.getText(); 
		newTypeof.setType_of(newType);
		System.out.println(newType);
			
		try {
			newTypee.addUser(newTypeof);
			System.out.println("The Information are saved !");
			newTypeOf.setText("");
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	@FXML
	private void movieInterface(ActionEvent e3) {
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/DeleteMovie.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Add new movie");
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	private void deleteMovie(ActionEvent e4) {
		 try {
		    	
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/DeleteMovie.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Delete movie");
				stage.setScene(new Scene(root));
				stage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
