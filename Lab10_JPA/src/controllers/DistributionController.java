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
import model.Distribution;
import model.KindOfMovie;
import services.DistributionService;

public class DistributionController {
	@FXML
	public ListView<Distribution> distributionList;
	@FXML
	private Button addDistribution;
	@FXML
	private TextField directorNameField;
	@FXML
	private TextField scenaristField;
	@FXML
    private TableView<Distribution> tableDirectorWriter;
	@FXML
	private TableColumn<Distribution, String> director;
	@FXML
	private TableColumn<Distribution, String> idDistribution;
	@FXML
	private TableColumn<Distribution, String> scenario;
	@FXML
	void initialize() {
		DistributionService  newDistrib=new DistributionService();
		List<Distribution> allDistrib = newDistrib.getAllUsers();
		System.out.println(allDistrib);
	//	distributionList.setItems(FXCollections.observableArrayList(new ArrayList<Distribution>(allDistrib)));   //modificat din listView in tableView 
		
		ObservableList<Distribution> listDistribution= FXCollections.observableArrayList(new ArrayList<Distribution>(allDistrib));
		idDistribution.setCellValueFactory(new PropertyValueFactory<Distribution,String>("idDistribution"));
		director.setCellValueFactory(new PropertyValueFactory<Distribution,String>("director"));
		scenario.setCellValueFactory(new PropertyValueFactory<Distribution,String>("scenario"));
		tableDirectorWriter.setItems(listDistribution);
		System.out.println(listDistribution);
	}
	
	@FXML
	private void addDistribution(ActionEvent e1)
	{
		DistributionService  newDistrib=new DistributionService();
		Distribution distrib=new Distribution();
		
		String directorName=directorNameField.getText();
		String scenarist=scenaristField.getText();
					
		distrib.setDirector(directorName);
		distrib.setScenario(scenarist);
				
		try {
			newDistrib.addUser(distrib);
		System.out.println("The new information are save:"+ directorName + scenarist);
		
		} catch (Exception e) {
		    e.printStackTrace();
		    showAlert();
		}	
		directorNameField.clear();
		scenaristField.clear();
	}
	@FXML
	private void deletDistribution(ActionEvent e2)
	{
				
	}
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Please write a name in the textBox !");
		alert.showAndWait();
	}
	

}
