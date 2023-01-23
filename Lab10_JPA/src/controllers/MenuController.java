package controllers;

import java.awt.Label;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.glass.events.MouseEvent;

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
import model.Movie;
import services.AddMovieService;
import services.MovieService;
import model.KinfOfMovie;
import model.LoginUser;


public class MenuController {

	@FXML
	public ListView<Movie> movieListView;
	@FXML
	public ListView<KinfOfMovie> genreListView;
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
	private Button removeGenre;
	@FXML
	private Button distributionButton;
	@FXML
	private TextField newTypeOf;
	@FXML
	private TextField removeField;
	@FXML
	private TextField timeLabel;
	@FXML
	private Label newTime;
	

	@FXML
	void initialize() {
		AddMovieService newService =new AddMovieService();
		List<Movie> allMovie =newService.getAllUsers();
		
		MovieService newGener=new MovieService();
		List<KinfOfMovie> allGenre=newGener.getAllUsers();
	
		movieListView.setItems(FXCollections.observableArrayList(new ArrayList<Movie>(allMovie)));
		genreListView.setItems(FXCollections.observableArrayList(new ArrayList<KinfOfMovie>(allGenre)));
		}

	@FXML
	private void refreshList(ActionEvent e) {
		AddMovieService newService =new AddMovieService();
		List<Movie> allMovie =newService.getAllUsers();
		
		MovieService newGener=new MovieService();
		List<KinfOfMovie> allGenre=newGener.getAllUsers();
	
		movieListView.setItems(FXCollections.observableArrayList(new ArrayList<Movie>(allMovie)));
		genreListView.setItems(FXCollections.observableArrayList(new ArrayList<KinfOfMovie>(allGenre)));
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
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/AddDeletMovieInterface.fxml"));
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
	@FXML
	private void addDistribution()
	{
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/AddDistribution.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Add new director and scenarist");
			stage.setScene(new Scene(root));
			stage.show();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
	  
}
	@FXML
	private void removeSelectedGenre(ActionEvent e6)
	{
		String remName= removeField.getText();
		MovieService newObj =new MovieService();
		try {
		newObj.findType(remName);
		System.out.println(remName);
	 	} catch (Exception e) {
		
			e.printStackTrace();
		}
		removeField.setText(" ");
		
	}
	
	
}
