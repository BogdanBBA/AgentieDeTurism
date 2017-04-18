package ui.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import classes.proxy.SafeProxyAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.GraphicMethods;


public class MainViewController
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
	private Button buttonSearch;
	@FXML
	private ComboBox<String> accomodationCombo;
	@FXML
	private DatePicker checkinPicker;
	@FXML
	private DatePicker checkoutPicker;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField destinationField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private ScrollPane scroll;
	@FXML
	private Label noResultLabel;
	@FXML
	private VBox v;
	
	private Stage primaryStage=new Stage();
	private SafeProxyAccount safeAccount;
	public GraphicMethods graphicM=new GraphicMethods();
	List<Button> buttons=new ArrayList<Button>();
	private ObservableList<String> accomodations = FXCollections.observableArrayList("Hotel","Motel","Inns","Guesthouse");
	private String chosenAccomodation;
	private LocalDate inDate;
	private LocalDate outDate;

	public void setSafeAccount(SafeProxyAccount safeAcc)
	{
		this.safeAccount=safeAcc;
	}
	
	public void initializeListOfOffers(VBox v,ScrollPane scrollPane)
	{
		
		for(int i=0;i<7;i++)
		{
			String uri="/ui/images/logo"+i+".png";
			Image image = new Image(uri);
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			Button button=new Button("I love you", imageView);
			button.setText("Button"+i);
			button.setId(i+"");
			button.setContentDisplay(ContentDisplay.TOP);
			button.setOnAction(new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event) 
				{
		        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/view/OfferView.fxml"));
		  			Parent root;
					try 
					{
						root = (Parent)fxmlLoader.load();
						OfferViewController controller = fxmlLoader.<OfferViewController>getController();
						controller.setImageView(uri);
						controller.setSafeAccount(safeAccount);
						controller.setInDate(inDate);
						controller.setOutDate(outDate);
		  				controller.setView();
		  				Scene scene = new Scene(root,1024,768);
		  				scene.getStylesheets().add(getClass().getResource("/ui/style/style.css").toExternalForm());
		  				primaryStage.setScene(scene);
		  				primaryStage.show();
		  				graphicM.closeStage(event);
			  				
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
	        });
			
			button.setMinWidth(v.getPrefWidth());
			v.getChildren().add(button);
			buttons.add(button);
		}
		
	}
	
	public void initializeComboBox()
	{
		accomodationCombo.setItems(accomodations);
		
		accomodationCombo.setPromptText("Choose accomodation type");        
		accomodationCombo.setOnAction((ActionEvent ev) -> {
			chosenAccomodation =  accomodationCombo.getSelectionModel().getSelectedItem().toString();    
		});
	}
	
	public void initialize()
	{
		graphicM.isLoggedin(safeAccount, buttonLogout, accordion);
		initializeComboBox();
		
		v = new VBox();
	    v.setAlignment(Pos.TOP_RIGHT);
	    v.setSpacing(20);
	    v.setPrefSize(640, 671);
	    leftPane.setPrefWidth(1024-955);
	    
	    ScrollPane scrollPane = new ScrollPane(v);
	    scrollPane.setFitToHeight(true);
	    scrollPane.setMaxWidth(655);
	    initializeListOfOffers(v,scrollPane);
	    border.setCenter(scrollPane);
	}
	
	
	@FXML
    private void search(ActionEvent event)
	{
		String result="";
		String destination=destinationField.getText();
		inDate = checkinPicker.getValue();
		outDate = checkoutPicker.getValue();
		
		
		if(destination.isEmpty() && inDate==null && outDate==null && chosenAccomodation==null)
		{
			graphicM.showMyAlert("No search criteria!", "  Please enter the criteria needed for search.");
		}
		else
		{
			if(result.isEmpty())
				graphicM.showMyAlert("No search result!", "  Please change the criteria for search and try again.");
			else
			{
				v.getChildren().clear();
				for(int i=0;i<4;i++)
					v.getChildren().add(buttons.get(i));
			}
		}
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