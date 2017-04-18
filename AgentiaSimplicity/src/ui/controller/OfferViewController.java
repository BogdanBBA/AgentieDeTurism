package ui.controller;

import java.time.LocalDate;

import classes.proxy.SafeProxyAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.GraphicMethods;

public class OfferViewController 
{
	@FXML
	private Pane leftPane;
	@FXML
	private Accordion accordion;
	@FXML
	private BorderPane border;
	@FXML
	private Button buttonLogout;
	@FXML
	private Button buttonLogin;
	@FXML
	private Button buttonCalculatePrice;
	@FXML
	private Button buttonReserve;
	@FXML
	private Button back;
	@FXML
	private DatePicker checkinPicker;
	@FXML
	private DatePicker checkoutPicker;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField priceField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label pictureLabel;
	@FXML
	private TextArea basicInfoText;
	@FXML
	private TextArea extraInfoText;	
	@FXML
	private ComboBox<String> roomCombo;
	@FXML
	private ComboBox<String> facilitiesCombo;
	@FXML
	private ComboBox<String> travelCombo;
	@FXML
	private ImageView imageView;
	private Stage primaryStage=new Stage();
	
	private ObservableList<String> rooms = FXCollections.observableArrayList("Single room","Double room","Apartment");
	private ObservableList<String> facilities = FXCollections.observableArrayList("Basic","All inclusive","Ultra all inclusive");
	private ObservableList<String> travel = FXCollections.observableArrayList("Not included","By plane","By bus");
	private SafeProxyAccount safeAccount;
	public GraphicMethods graphicM=new GraphicMethods();
	private String chosenRoom;
	private String chosenFacility;
	private String travellingType;
	
	
	public SafeProxyAccount getSafeAccount() 
	{
		return safeAccount;
	}
	
	public void setSafeAccount(SafeProxyAccount safeAccount) 
	{
		this.safeAccount = safeAccount;
	}
	
	public void setImageView(String uri) 
	{
		Image image = new Image(uri,417,398,false, false);
		imageView = new ImageView();
		imageView.setImage(image);
	}
	
	public void initializeComboBoxes()
	{
		roomCombo.setItems(rooms);
		facilitiesCombo.setItems(facilities);
		travelCombo.setItems(travel);
		
		roomCombo.setPromptText("Choose room type");        
		roomCombo.setOnAction((ActionEvent ev) -> {
			chosenRoom =  roomCombo.getSelectionModel().getSelectedItem().toString();    
		});
		
		facilitiesCombo.setPromptText("Choose facilities type");        
		facilitiesCombo.setOnAction((ActionEvent ev) -> {
			chosenFacility =  facilitiesCombo.getSelectionModel().getSelectedItem().toString();    
		});
		
		travelCombo.setPromptText("Choose travelling type");        
		travelCombo.setOnAction((ActionEvent ev) -> {
			travellingType =  travelCombo.getSelectionModel().getSelectedItem().toString();    
		});
	}
	
	public void setView()
	{
		initializeComboBoxes();
		graphicM.isLoggedin(safeAccount, buttonLogout, accordion);
		imageView.setImage(new Image("/ui/images/mypic.jpg",412,393,false, false));
		pictureLabel.setGraphic(imageView);
	}
	
	@FXML
    private void calculatePrice(ActionEvent event)
	{
		LocalDate inDate = checkinPicker.getValue();
		LocalDate outDate = checkoutPicker.getValue();
	}
	
	@FXML
    private void reserve(ActionEvent event)
	{
		LocalDate inDate = checkinPicker.getValue();
		LocalDate outDate = checkoutPicker.getValue();
		if(safeAccount==null)
			graphicM.showMyAlert("Not logged in!", "  You must be logged in in order to make a reservation.");
		else
		{
			if(safeAccount.reserve())
			{
				//->make payment
			}
			else
				graphicM.showMyAlert("Not logged in!", "  You must be logged in in order to make a reservation.");
		}
	}
	
	@FXML
    private void back(ActionEvent event)
	{
		graphicM.loadMainStage(primaryStage);
		graphicM.closeStage(event);
	}
	
	@FXML
    private void login(ActionEvent event)
	{
		graphicM.login(safeAccount,buttonLogout,accordion,usernameField,passwordField);
	}
	
	@FXML
    private void logout(ActionEvent event)
	{
		graphicM.logout(safeAccount,buttonLogout,accordion);
	}

}