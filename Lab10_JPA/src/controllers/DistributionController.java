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
import javafx.scene.input.MouseEvent;
import model.Distribution;
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
    private TextField idField;
	@FXML
    private Button deleteButton;
	@FXML
    private Button updateButton;
	@FXML
    private TableView<Distribution> tableDirectorWriter;
	@FXML
	private TableColumn<Distribution, String> director;
	@FXML
	private TableColumn<Distribution, Integer> idDistribution;
	@FXML
	private TableColumn<Distribution, String> scenario;
	Integer index;
	@FXML
	void initialize() {
		DistributionService  newDistrib=new DistributionService();
		List<Distribution> allDistrib = newDistrib.getAllUsers();
		//System.out.println(allDistrib);
			
		ObservableList<Distribution> listDistribution= FXCollections.observableArrayList(new ArrayList<Distribution>(allDistrib));
		idDistribution.setCellValueFactory(new PropertyValueFactory<Distribution,Integer>("idDistribution"));
		director.setCellValueFactory(new PropertyValueFactory<Distribution,String>("director"));
		scenario.setCellValueFactory(new PropertyValueFactory<Distribution,String>("scenario"));
		
		tableDirectorWriter.setItems(listDistribution);
		//System.out.println(listDistribution);
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
		idField.clear();
	}
	 @FXML
	    void getItem(MouseEvent e) {
		 index = tableDirectorWriter.getSelectionModel().getSelectedIndex();
		 if(index==-1)
		 {
			 return;
		 }
		 idField.setText(idDistribution.getCellData(index).toString());
		 directorNameField.setText(director.getCellData(index).toString());
		 scenaristField.setText(scenario.getCellData(index).toString());

	  }
	 @FXML
	 private void updateUser(ActionEvent e2){
		 DistributionService  newDistrib=new DistributionService();
		 String idStr =idField.getText();
		 int id = Integer.parseInt(idStr);
		 Distribution distrib=newDistrib.find(id);
		 System.out.println(distrib);
		 
		 String director=directorNameField.getText();
		 String scenario=scenaristField.getText();
		 
		 distrib.setDirector(director);
		 distrib.setScenario(scenario);
		 try {
			 newDistrib.updateUser(distrib);
			} catch (Exception e) {
				e.printStackTrace();
			}
		     directorNameField.clear();
			scenaristField.clear();
			idField.clear();
		 
		 
	 }
	@FXML
	private void deletDistribution(ActionEvent e2)
	{
		DistributionService  newDistriib=new DistributionService();
		String idStr =idField.getText();
		int id = Integer.parseInt(idStr);
		Distribution distribb=new Distribution();
		try {
			newDistriib.remove(distribb, id);
			} catch (Exception e) {
			
				e.printStackTrace();
				showAlert();
			}	
		directorNameField.clear();
		scenaristField.clear();
		idField.clear();
	}
	private void showAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText("Invalin input !");
		alert.setContentText("Please write a name in the textBox !");
		alert.showAndWait();
	}
	@FXML
	private void refreshList(ActionEvent e)
	{
		DistributionService  newDistrib=new DistributionService();
		List<Distribution> allDistrib = newDistrib.getAllUsers();
		//System.out.println(allDistrib);
			
		ObservableList<Distribution> listDistribution= FXCollections.observableArrayList(new ArrayList<Distribution>(allDistrib));
		idDistribution.setCellValueFactory(new PropertyValueFactory<Distribution,Integer>("idDistribution"));
		director.setCellValueFactory(new PropertyValueFactory<Distribution,String>("director"));
		scenario.setCellValueFactory(new PropertyValueFactory<Distribution,String>("scenario"));
		
		tableDirectorWriter.setItems(listDistribution);
	}
	

}
