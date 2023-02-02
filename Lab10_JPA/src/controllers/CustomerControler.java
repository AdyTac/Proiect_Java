package controllers;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Customer;
import services.CustomerService;

public class CustomerControler {

    @FXML
    private Button CustomerUpdate;
    @FXML
    private Button addCustomerButton;
    @FXML
    private DatePicker customerDate;
    @FXML
    private Button customerDelete;
    @FXML
    private TextField customerEmail;
    @FXML
    private TextField customerFirstname;
     @FXML
     private TextField customerID;
     @FXML
     private TextField customername;
     @FXML
	 private TableView<Customer> customerTable;
	 @FXML
	 private TableColumn<Customer, String> emailCustomer;
	 @FXML
	 private TableColumn<Customer, String> firstNameCustomer;
	 @FXML
	 private TableColumn<Customer, Integer> idCustomer;
	 @FXML
	 private TableColumn<Customer, String> nameCustomer;
	 @FXML
	 private TableColumn<Customer, String> registerDateCustom;
	 Integer index;
	 
	
    @FXML
	void initialize() {
		CustomerService objCustomer =new CustomerService();
		List<Customer> allCustomer = objCustomer.getAllUsers();
		//System.out.println(allDistrib);
			
		ObservableList<Customer> listOfCustomer= FXCollections.observableArrayList(new ArrayList<Customer>(allCustomer));
		
		idCustomer.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("idCustomer"));
		nameCustomer.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
		firstNameCustomer.setCellValueFactory(new PropertyValueFactory<Customer,String>("firstName"));
		emailCustomer.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
		
		customerTable.setItems(listOfCustomer);
		System.out.println(listOfCustomer);
	}
    @FXML
	 private void updateUser(ActionEvent e2){
		CustomerService  newCustomST= new CustomerService();
		String idStr =idCustomer.getText();
		int id = Integer.parseInt(idStr);
		
		Customer newCust=newCustomST.find(id);
		System.out.println(newCust);

		String name=customername.getText();
		String firstName=customerFirstname.getText();
		String email=customerEmail.getText();

		newCust.setName(name);
		newCust.setFirstName(firstName);
		newCust.setEmail(email);
		try {
			newCustomST.updateUser(newCust);
		} catch (Exception e) {
			e.printStackTrace();
			}
		customername.clear();
		customerFirstname.clear();
		customerEmail.clear();
		customerID.clear();
		initialize() ;
	 }
    @FXML
     void getItem(MouseEvent e) {
	 index = customerTable.getSelectionModel().getSelectedIndex();
	 if(index==-1)
	 {
		 return;
	 }
	 customerID.setText(idCustomer.getCellData(index).toString());
	 customerFirstname.setText(firstNameCustomer.getCellData(index).toString());
	 customername.setText(nameCustomer.getCellData(index).toString());
	 customerEmail.setText(emailCustomer.getCellData(index).toString());
  }
    
    
	

}
