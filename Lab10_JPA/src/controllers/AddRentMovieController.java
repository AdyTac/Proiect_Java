package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Customer;
import model.MovieProduction;
import model.Rentdata;
import services.AddMovieService;
import services.CustomerService;
import services.RentDataService;

public class AddRentMovieController {
	@FXML
	private TableView<MovieProduction> rentTable;
	@FXML
	 private TableColumn<MovieProduction, Integer> movieId;
	@FXML
	private TableColumn<MovieProduction,String> titleMovie;
	@FXML
	private TableView<Customer> rentTable1;
	@FXML
	 private TableColumn<Customer, Integer> customerID;
	@FXML
	private TableColumn<Customer, String> customeName;
	@FXML
	private DatePicker  PickUpData;
	@FXML 
	private TextField  movieIdField;
	@FXML 
	private TextField titelField;
	@FXML 
	private TextField customerIDField;
	@FXML 
	private TextField 	customerName;
	@FXML
	private TableView<Rentdata> rentDataTable;
	@FXML
	 private TableColumn<Rentdata, String> pickUpDate;
	@FXML
	private TableColumn<Rentdata,String> returnDate;
	
	
	Integer index;

	@FXML
	void initialize() {
		AddMovieService newService =new AddMovieService();
	    List<MovieProduction> allMovie =newService.getAllUsers();
	    ObservableList<MovieProduction> listMovie= FXCollections.observableArrayList(new ArrayList<MovieProduction>(allMovie));
	    movieId.setCellValueFactory(new PropertyValueFactory<MovieProduction,Integer>("movieId"));
	    titleMovie.setCellValueFactory(new PropertyValueFactory<MovieProduction,String>("title"));
	    rentTable.setItems(listMovie);
	    
	    CustomerService objCustomer =new CustomerService();
		List<Customer> allCustomer = objCustomer.getAllUsers();
		ObservableList<Customer> listOfCustomer= FXCollections.observableArrayList(new ArrayList<Customer>(allCustomer));
		customerID.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("idCustomer"));
		customeName.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
		rentTable1.setItems(listOfCustomer);
		
		RentDataService newRent= new RentDataService();
		List<Rentdata> allRent = newRent.getAllUsers();
		ObservableList<Rentdata> listOfRent= FXCollections.observableArrayList(new ArrayList<Rentdata>(allRent));
		pickUpDate.setCellValueFactory(new PropertyValueFactory<Rentdata,String>("pickUpData"));
		returnDate.setCellValueFactory(new PropertyValueFactory<Rentdata,String>("returnData"));
		rentDataTable.setItems(listOfRent);
		
	}
	
	
	
	@FXML
    void getItem(MouseEvent e) {
	 index = rentTable.getSelectionModel().getSelectedIndex();
	 if(index==-1)
	 {
		 return;
	 }
	 movieIdField.setText(movieId.getCellData(index).toString());
	 titelField.setText(titleMovie.getCellData(index).toString());
	 customerName.setText(customeName.getCellData(index).toString());
	 customerIDField.setText(customerID.getCellData(index).toString());
	
	 
	 }

}
