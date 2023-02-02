package controllers;

import java.awt.Label;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.MovieProduction;
import services.AddMovieService;
import services.MovieService;
import model.KindOfMovie;


public class MenuController {

	@FXML
	public ListView<MovieProduction> movieListView;
	@FXML
	public ListView<KindOfMovie> genreListView;
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
	private Button rentAMovieButton;
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
	private TextField genreIDField;
	@FXML
	private TableView<KindOfMovie>  tabelData;
	@FXML
	private TableColumn<KindOfMovie,Integer> genreID;
	@FXML
	private TableColumn<KindOfMovie,String> genreName;
	 @FXML
	 private TableView<MovieProduction> movieTable;
	 @FXML
	 private TableColumn<MovieProduction,String> title;
	 @FXML
	 private TableColumn<MovieProduction, Integer> IMDB_rating;
	 @FXML
	 private TableColumn<MovieProduction, Integer> budget;
	 @FXML
	 private TableColumn<MovieProduction,String> homepage;
	 @FXML
	 private TableColumn<MovieProduction, String> movieId;
	 @FXML
	 private TableColumn<MovieProduction, String> releaseDate;
	 @FXML
	 private TableColumn<MovieProduction, String> runtime;
	 Integer index;

	@FXML
	void initialize() {
    	AddMovieService newService =new AddMovieService();
	    List<MovieProduction> allMovie =newService.getAllUsers();
		
		MovieService newGener=new MovieService();
		List<KindOfMovie> allGenre=newGener.getAllUsers();
	
		//movieListView.setItems(FXCollections.observableArrayList(new ArrayList<MovieProduction>(allMovie)));
		//genreListView.setItems(FXCollections.observableArrayList(new ArrayList<KindOfMovie>(allGenre)));
		
		ObservableList<MovieProduction> listMovie= FXCollections.observableArrayList(new ArrayList<MovieProduction>(allMovie));
		movieId.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("movieId"));
		title.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("title"));
		budget.setCellValueFactory(new PropertyValueFactory<MovieProduction,Integer>("budget"));
		homepage.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("homepage"));
		releaseDate.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("releaseDate"));
		IMDB_rating.setCellValueFactory(new PropertyValueFactory<MovieProduction,Integer>("IMDB_rating"));
		runtime.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("runtime"));
		movieTable.setItems(listMovie);
		
		ObservableList<KindOfMovie> list= FXCollections.observableArrayList(new ArrayList<KindOfMovie>(allGenre));
	    genreID.setCellValueFactory(new PropertyValueFactory<KindOfMovie,Integer>("idKind"));
		genreName.setCellValueFactory(new PropertyValueFactory<KindOfMovie,String>("type_of"));
		tabelData.setItems(list);
		System.out.println(list);
	
		}

	
	@FXML
	private void actorInterface(ActionEvent e1) {
try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/AddActor.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Actor add/delete");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			showAlert();
		}
		
	}
	@FXML
	private void typeOfMoviInterface(ActionEvent e2) {
		MovieService  newTypee= new MovieService();
		KindOfMovie newTypeof= new KindOfMovie();
		
		String newType=newTypeOf.getText(); 
		newTypeof.setType_of(newType);
		System.out.println(newType);
			
		try {
			newTypee.addUser(newTypeof);
			System.out.println("The Information are saved !");
			newTypeOf.setText("");
			
		} catch (Exception e) {
		    e.printStackTrace();
		    showAlert();
		}
	}
	@FXML
	private void movieInterface(ActionEvent e3) {
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/AddDeletMovieInterface.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Add new movie");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
			showAlert();
		}
		
	}
	@FXML
	private void deleteMovie(ActionEvent e4) {

		 try {
		    	
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/DeleteMovie.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Delete movie");
				stage.setResizable(false);
				stage.setScene(new Scene(root));
				stage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
				showAlert();
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
			stage.setResizable(false);
			stage.show();
		
		}catch (IOException e) {
			e.printStackTrace();
			showAlert();
		}
	  
}
	
	 @FXML
	void getItem(MouseEvent e) {
		 index = tabelData.getSelectionModel().getSelectedIndex();
		 if(index==-1)
		 {
			 return;
		 }
		removeField.setText(genreName.getCellData(index).toString());
		genreIDField.setText(genreID.getCellData(index).toString());
		
	  }
	
	@FXML
	private void removeSelectedGenre(ActionEvent e6)
	{  
		MovieService genreObj =new MovieService();
		String idStr =genreIDField.getText();
		int id = Integer.parseInt(idStr);
		KindOfMovie newGenre =new KindOfMovie();
		try {
			genreObj.remove(newGenre, id);
	 	} catch (Exception e) {
		
			e.printStackTrace();
		}
		genreIDField.clear();
		removeField.clear();
	}
	@FXML
	private void editUserList(ActionEvent e6)
	{
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/EditUserAccess.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Modifi the users");
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
		
		}catch (IOException e) {
			e.printStackTrace();
			showAlert();
		}
		
		
	}

	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Please check the error !");
		alert.showAndWait();
	}
	@FXML
	private void refreshList(ActionEvent e) {
		AddMovieService newService =new AddMovieService();
		List<MovieProduction> allMovie =newService.getAllUsers();
		
		MovieService newGener=new MovieService();
		List<KindOfMovie> allGenre=newGener.getAllUsers();
		
		ObservableList<MovieProduction> listMovie= FXCollections.observableArrayList(new ArrayList<MovieProduction>(allMovie));
		movieId.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("movieId"));
		title.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("title"));
		budget.setCellValueFactory(new PropertyValueFactory<MovieProduction,Integer>("budget"));
		homepage.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("homepage"));
		releaseDate.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("releaseDate"));
		IMDB_rating.setCellValueFactory(new PropertyValueFactory<MovieProduction,Integer>("IMDB_rating"));
		runtime.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("runtime"));
		movieTable.setItems(listMovie);
		
		ObservableList<KindOfMovie> list= FXCollections.observableArrayList(new ArrayList<KindOfMovie>(allGenre));
	    genreID.setCellValueFactory(new PropertyValueFactory<KindOfMovie,Integer>("idKind"));
		genreName.setCellValueFactory(new PropertyValueFactory<KindOfMovie,String>("type_of"));
		tabelData.setItems(list);
		System.out.println(list);
	
		
	}
	@FXML
	private void rentAMovie(ActionEvent e) {
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/RentMovieInterface.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Add new movie");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		
		}catch (IOException ext) {
			ext.printStackTrace();
			showAlert();
		}
		
	}
	
	
	
	
}
