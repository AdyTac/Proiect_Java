package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
	void initialize() {
		DistributionService  newDistrib=new DistributionService();
		List<Distribution> allDistrib = newDistrib.getAllUsers();
		System.out.println(allDistrib);
		distributionList.setItems(FXCollections.observableArrayList(new ArrayList<Distribution>(allDistrib)));
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
		directorNameField.setText("");
		scenaristField.setText("");
			
		} catch (Exception e) {
		    e.printStackTrace();
		}	
	}
	@FXML
	private void deleteMovie(ActionEvent e2)
	{
				
	}
	

}
