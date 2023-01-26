package controllers;
import java.time.LocalDate;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Actor;
import model.Distribution;
import model.KindOfMovie;
import model.MovieProduction;
import services.ActorService;
import services.AddMovieService;
import services.DistributionService;
import services.MovieService;

public class AddDeleteMovie {

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
		
		movieNameField.setText("" );
		bugetTextField.setText("");
	    homePageField.setText(" ");
		ratingField.setText(" ");
		runTimeField.setText(" ");
		overViewField.setText(" ");
		
		nameField.setText(" ");
		nameFirstField.setText(" ");
		rolesField.setText(" ");
		
		directorNameField.setText(" ");
		scenaristField.setText("");
	}
	@FXML
	private void deleteMovie(ActionEvent e2)
	{

		String remName= deleteMovieField.getText();
		AddMovieService newObj =new AddMovieService();
		try {
		newObj.findType(remName);
		System.out.println(remName);
	 	} catch (Exception e) {
		
			e.printStackTrace();
			showAlert();
		}
		deleteMovieField.setText(" ");
		
	}
	
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Please write a name in the textBox !");
		alert.showAndWait();
	}
	

}
