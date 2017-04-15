package ui.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import classes.User;
import classes.proxy.SafeProxyAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import ui.GraphicMethods;


public class MainViewController
{
	@FXML
	private Accordion accordion;
	@FXML
	private BorderPane border;
	@FXML
	private Button buttonLogout;
	@FXML
	private Button buttonLogin;
	@FXML
	private Button buttonSearch;
	@FXML
	private ComboBox roomCombo;
	@FXML
	private ComboBox accomodationCombo;
	@FXML
	private DatePicker checkinPicker;
	@FXML
	private DatePicker checkoutPicker;
	@FXML
	private ListView<String> listView ;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField destinationField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private ScrollPane scroll;
	
	private SafeProxyAccount safeAccount;
	public GraphicMethods grapicM=new GraphicMethods();
	
	public void setSafeAccount(SafeProxyAccount safeAcc)
	{
		this.safeAccount=safeAcc;
	}
	
	
	public void initialize()
	{
		/*VBox hbox = new VBox();
		List<Button> l=new ArrayList<Button>();
		for(int i=0;i<20;i++)
			hbox.getChildren().add(new Button());
		scroll.setContent(hbox);
			
		HBox hbox = new HBox();
		border.setTop(hbox);
		hbox.setPadding(new Insets(5, 5, 5, 5));
		Image image = new Image("/images/logo.png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		Button buttonCurrent = new Button("Log in");
		hbox.getChildren().add(buttonCurrent);
		buttonCurrent.setPrefSize(120, 60);
		VBox vbox = new VBox();
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		vbox.getChildren().add(imageView);
		hbox.getChildren().add(vbox);
		vbox.setStyle("-fx-background-color:blue;");
		hbox.setPrefHeight(60);
		
		HBox hBox=new HBox();
        hBox.getChildren().add(imageView);
        hBox.setAlignment(Pos.BASELINE_LEFT);
        hBox.setPadding(new Insets(0, 0, 5, 20));
        border.getChildren().add(hBox);*/
		/*ObservableList<String> names = FXCollections.observableArrayList("Adam", "Alex", "Alfred", "Albert",
	             "Brenda", "Connie", "Derek", "Donny", 
	             "Lynne", "Myrtle", "Rose", "Rudolph", 
	             "Tony", "Trudy", "Williams", "Zach");
	         
	          
	    listView.setItems(names);*/
		
	}
	@FXML
    private void search(ActionEvent event)
	{
		String destination=destinationField.getText();
		LocalDate inDate = checkinPicker.getValue();
		LocalDate outDate = checkoutPicker.getValue();
		System.out.println(destination);
	}
	
	@FXML
    private void login(ActionEvent event)
	{
		String username=usernameField.getText();
		String password=passwordField.getText();
		User user=new User(username,password);
		safeAccount=new SafeProxyAccount(user);
		
		if(!safeAccount.login(user))
		{
			safeAccount=null;
			grapicM.showAlert("Login failed", "There is a problem with your username/password. Please try again");
		}
		else
		{
			accordion.setVisible(false);
			buttonLogout.setVisible(true);
		}
		
		
	}
}