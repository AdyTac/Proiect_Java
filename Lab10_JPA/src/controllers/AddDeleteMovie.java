package controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Actor;
import model.Distribution;
import model.KindOfMovie;
import model.LoginUser;
import model.MovieProduction;
import services.ActorService;
import services.AddMovieService;
import services.DistributionService;
import services.MovieService;
import services.UserServices;

public class AddDeleteMovie {
	@FXML
	private TextField idMovieField;
	@FXML
	private Button addNewMovieButton;
	@FXML
	private TextField movieNameField;
	@FXML
	private TextField bugetTextField; 
	@FXML
	private TextField homePageField;
	@FXML
	private TextField ratingField;
	@FXML
	private TextField overViewField;
	@FXML
	private TextField runTimeField;
	@FXML
	private Button deleteMovieButton;
	@FXML
	private TextField deleteMovieField;
	 @FXML
	private DatePicker myDatePicker;
	@FXML
	private TextField nameField;
	@FXML
	private TextField nameFirstField;
	@FXML
	private TextField rolesField;
	@FXML
	private TextField newTypeOf;
	@FXML
	private TextField directorNameField;
	@FXML
	private TextField scenaristField;
	 @FXML
	 private TableView<MovieProduction> movieTable;
	 @FXML
	 private TableColumn<MovieProduction,String> title;
	 @FXML
	 private TableColumn<MovieProduction, String> IMDB_rating;
	 @FXML
	 private TableColumn<MovieProduction, Integer> budget;
	 @FXML
	 private TableColumn<MovieProduction,String> homepage;
	 @FXML
	 private TableColumn<MovieProduction, Integer> movieId;
	 @FXML
	 private TableColumn<MovieProduction, String> releaseDate;
	 @FXML
	 private TableColumn<MovieProduction, Integer> runtime;
	 @FXML
	 private TableColumn<MovieProduction, String> overView;
	 Integer index;
	 @FXML
	void initialize() {
			AddMovieService newService =new AddMovieService();
		    List<MovieProduction> allMovie =newService.getAllUsers();
			
			ObservableList<MovieProduction> listMovie= FXCollections.observableArrayList(new ArrayList<MovieProduction>(allMovie)); 
			movieId.setCellValueFactory(new PropertyValueFactory<MovieProduction,Integer>("movieId"));
			title.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("title"));
			budget.setCellValueFactory(new PropertyValueFactory<MovieProduction,Integer>("budget"));
			homepage.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("homepage"));
			releaseDate.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("releaseDate"));
			IMDB_rating.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("IMDB_rating"));
			runtime.setCellValueFactory(new PropertyValueFactory<MovieProduction,Integer>("runtime"));
			overView.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("overview"));
			
			
			movieTable.setItems(listMovie);
		}
	 
	@FXML
	private void addNewMovie(ActionEvent e1)
	{  
				
		AddMovieService newObject=new AddMovieService();
		MovieProduction newMovi=new MovieProduction();
		
		String title=movieNameField.getText();
		newMovi.setTitle(title);
		
		String buget=bugetTextField.getText();
		int bugget = Integer.parseInt(buget);
       	newMovi.setBudget(bugget);

    	String homePage=homePageField.getText();
       	newMovi.setHomepage(homePage);
    	
    	String rating =ratingField.getText();
    	int ratting= Integer.parseInt(rating); 
    	newMovi.setIMDB_rating(ratting);
       	
    	String runTime=runTimeField.getText();
    	int runttime =Integer.parseInt(runTime);
    	newMovi.setRuntime(runttime);
    	       	
    	String overView =overViewField.getText();
    	newMovi.setOverview(overView);
    	
    	LocalDate myDate = myDatePicker.getValue();
    	
    	ActorService  newActorService= new ActorService();
		Actor newActor=new Actor();
		
		String name=nameField.getText();
		String firstname=nameFirstField.getText();
		String roles=rolesField.getText();
		newActor.setActorName(name);
		newActor.setActorFirstName(firstname);
		newActor.setActorRole(roles);
		
		MovieService  newTypee= new MovieService();
		KindOfMovie newTypeof= new KindOfMovie();
		
		String newType=newTypeOf.getText(); 
		newTypeof.setType_of(newType);
		System.out.println(newType);
		
		DistributionService  newDistrib=new DistributionService();
		Distribution distrib=new Distribution();
		String directorName=directorNameField.getText();
		String scenarist=scenaristField.getText();
					
		distrib.setDirector(directorName);
		distrib.setScenario(scenarist);
		
		try {
		newObject.addUser(newMovi);
		newActorService.addUser(newActor);
		newTypee.addUser(newTypeof);
		newDistrib.addUser(distrib);
		System.out.println("The new Movie is saved!");
				
		} catch (Exception e) {
		    e.printStackTrace();
		    showAlert();
		}	
		
		movieNameField.clear();
		bugetTextField.clear();
	    homePageField.clear();
		ratingField.clear();
		runTimeField.clear();
		overViewField.clear();
		nameField.clear();
		nameFirstField.clear();
		rolesField.clear();
		directorNameField.clear();
		scenaristField.clear();
	}
	 @FXML
	    void getItem(MouseEvent e) {
		 index = movieTable.getSelectionModel().getSelectedIndex();
		 if(index==-1)
		 {
			 return;
		 }
		 idMovieField.setText(movieId.getCellData(index).toString());
		 movieNameField.setText(title.getCellData(index).toString());
		 homePageField.setText(homepage.getCellData(index).toString());
		 overViewField.setText(overView.getCellData(index).toString());
		 bugetTextField.setText(budget.getCellData(index).toString());
		 ratingField.setText(budget.getCellData(index).toString());
		 runTimeField.setText(runtime.getCellData(index).toString());
		
		
	  }
	@FXML
	private void deleteMovie(ActionEvent e2)
	{
		AddMovieService newMovieServ =new AddMovieService();
		String idStr =idMovieField.getText();
		int id = Integer.parseInt(idStr);
		MovieProduction newMovieProd =new MovieProduction();
		try {
			newMovieServ.remove(newMovieProd, id);
			} catch (Exception e) {
			
				e.printStackTrace();
				showAlert();
			}
				
	}
	
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Please write a name in the textBox !");
		alert.showAndWait();
	}
	

}
