package controllers;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Actor;
import services.ActorService;

public class AddDeleteActor {
	@FXML
	public ListView<Actor> actorList;
	@FXML
	private Button addNewActorButton;
	@FXML
	private TextField nameField;
	@FXML
	private TextField idField;
	@FXML
	private TextField nameFirstField;
	@FXML
	private TextField rolesField;
	@FXML
	private Button deleteActorButton;
	@FXML
	private Button updateActorButton;
	@FXML
    private Button refreshButton;
	@FXML
	private TextField deleteActorField;
	@FXML
	private TableView<Actor> actorTableView;
	@FXML
    private TableColumn<Actor, String> actorFirstName;
    @FXML
    private TableColumn<Actor,String> actorName;
    @FXML
    private TableColumn<Actor,String> actorRole;
    @FXML
    private TableColumn<Actor, Integer> idActor;
    Integer index;
  	@FXML
	void initialize() {
		ActorService  newActor=new ActorService();
		List<Actor> allActors = newActor.getAllUsers();
		
		ObservableList<Actor> listOffActors= FXCollections.observableArrayList(new ArrayList<Actor>(allActors));
		idActor.setCellValueFactory(new PropertyValueFactory<Actor,Integer>("idActor"));
		actorName.setCellValueFactory(new PropertyValueFactory<Actor,String>("actorName"));
		actorFirstName.setCellValueFactory(new PropertyValueFactory<Actor,String>("actorFirstName"));
		actorRole.setCellValueFactory(new PropertyValueFactory<Actor,String>("actorRole"));
		actorTableView.setItems(listOffActors);
		System.out.println(listOffActors);
	}
	@FXML
	private void addNewActor(ActionEvent e1)
	{
		
		String name=nameField.getText();
		String firstname=nameFirstField.getText();
		String roles=rolesField.getText();
	 	if(nameField.getText().equals("") && nameFirstField.getText().equals("") && rolesField.getText().equals(""))
		{
			showAlert();
		}
		else
		{
			ActorService  newActorService= new ActorService();
			Actor newActor=new Actor();	
	
		newActor.setActorName(name);
		newActor.setActorFirstName(firstname);
		newActor.setActorRole(roles);
		
		try {
		newActorService.addUser(newActor);
		System.out.println("The Information are saved !");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		nameField.clear();
		rolesField.clear();
		nameFirstField.clear();
		idField.clear();
	}
	}
	 @FXML
	    void getItem(MouseEvent e) {
		 index = actorTableView.getSelectionModel().getSelectedIndex();
		 if(index==-1)
		 {
			 return;
		 }
		 idField.setText(idActor.getCellData(index).toString());
		 nameFirstField.setText(actorFirstName.getCellData(index).toString());
		 nameField.setText(actorName.getCellData(index).toString());
		 rolesField.setText(actorRole.getCellData(index).toString());
	  }
	 @FXML
	    private void updateUser(ActionEvent e2){
		ActorService  newActorService= new ActorService();
		String idStr =idField.getText();
		int id = Integer.parseInt(idStr);
		Actor newActor=newActorService.find(id);
		System.out.println(newActor);

		String name=nameField.getText();
		String firstName=nameFirstField.getText();
		String role=rolesField.getText();

		newActor.setActorName(name);
		newActor.setActorFirstName(firstName);
		newActor.setActorRole(role);
		try {
			newActorService.updateUser(newActor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		nameField.clear();
		rolesField.clear();
		nameFirstField.clear();
		idField.clear();
	 }
	@FXML
	private void deleteActor(ActionEvent e2)
	{
		ActorService newObj= new ActorService();
		String idStr =idField.getText();
		int id = Integer.parseInt(idStr);
		Actor newActor= new Actor();
		try {
			newObj.remove(newActor, id);
			} catch (Exception e) {
			
				e.printStackTrace();
				showAlert();
		}
		nameField.clear();
		rolesField.clear();
		nameFirstField.clear();
		idField.clear();
		}
	@FXML
	private void refreshList(ActionEvent e) {
		ActorService  newActor=new ActorService();
		List<Actor> allActors = newActor.getAllUsers();
		
		ObservableList<Actor> listOffActors= FXCollections.observableArrayList(new ArrayList<Actor>(allActors));
		idActor.setCellValueFactory(new PropertyValueFactory<Actor,Integer>("idActor"));
		actorName.setCellValueFactory(new PropertyValueFactory<Actor,String>("actorName"));
		actorFirstName.setCellValueFactory(new PropertyValueFactory<Actor,String>("actorFirstName"));
		actorRole.setCellValueFactory(new PropertyValueFactory<Actor,String>("actorRole"));
		actorTableView.setItems(listOffActors);
	}
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Please write a name in the textBox !");
		alert.showAndWait();
	}
}
