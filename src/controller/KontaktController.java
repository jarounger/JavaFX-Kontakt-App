package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.KontaktModel;
import datenbank.Datenbank;

public class KontaktController implements Initializable {
	
	@FXML
	private TextField vornameTextField;

	@FXML
	private TextField nachnameTextField;
	
	@FXML
	private TextField mobileTextField;
	
	@FXML
	private TextField emailTextField;

	@FXML
	private Button addButton;
	
	@FXML
	private Button deleteButton;
	
	@FXML
    private Circle datenbankStatus;
	
	@FXML
    private TableView<KontaktModel> kontaktTableView;
    
    @FXML
    private TableColumn<KontaktModel, String> vornameColumn;
    
    @FXML
    private TableColumn<KontaktModel, String> nachnameColumn;
    
    @FXML
    private TableColumn<KontaktModel, String> mobileColumn;
    
    @FXML
    private TableColumn<KontaktModel, String> emailColumn;
	
	@FXML
	void addButtonEvent(ActionEvent event) {
		addKontakt();
		loadKontakt();
		
		vornameTextField.clear();
		nachnameTextField.clear();
		mobileTextField.clear();
		emailTextField.clear();
	}
	
   	@FXML
	void deleteButtonEvent(ActionEvent event) {
   		deleteKontakt();
   		loadKontakt();
    }
	
	private Datenbank datenbank = new Datenbank();	

	// Start
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boolean dbStatus = datenbank.open();
		if (dbStatus) {
			datenbankStatus.setFill(Color.GREEN);
			
			loadKontakt();
			
			} else {
				datenbankStatus.setFill(Color.RED);
			}
	}
	
	
	// Kontakt hinzufügen
	
	public void addKontakt() {
		String vorname = vornameTextField.getText();
		String nachname = nachnameTextField.getText();
		String mobile = mobileTextField.getText();
		String email = emailTextField.getText();
	
		try {
			datenbank.addKontakt(datenbank.getStatement(), vorname, nachname, mobile, email);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dfd");
		}
	}
	
	
	// Kontakt löschen
	
	public void deleteKontakt() {
		try {
			datenbank.deleteKontakt(datenbank.getStatement());
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
		
	// Kontakt Laden
	
	private ObservableList<KontaktModel> list;
	
	public void loadKontakt() {
		try {
			list = datenbank.loadKontakt(datenbank.getStatement(), list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		vornameColumn.setCellValueFactory(new PropertyValueFactory<KontaktModel, String>("vorname"));
		nachnameColumn.setCellValueFactory(new PropertyValueFactory<KontaktModel, String>("nachname"));
		mobileColumn.setCellValueFactory(new PropertyValueFactory<KontaktModel, String>("mobile"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<KontaktModel, String>("email"));
		
		kontaktTableView.setItems(list);
	}
	
}



