package ui.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import classes.Utils;
import classes.builder.IPackageOfferBuilder;
import classes.builder.PackageOffer;
import classes.builder.PackageOfferBuilder;
import classes.builder.PackageOfferBuilderAgent;
import classes.decorator.AllInclusivePackageOfferDecorator;
import classes.decorator.BasicPackageOffer;
import classes.decorator.IPackageLevel;
import classes.decorator.UltraAllInclusivePackageOfferDecorator;
import classes.model.ERoomType;
import classes.model.ETravelType;
import classes.model.Hotel;
import classes.proxy.SafeProxyAccount;
import classes.strategy.TravelByBus;
import classes.strategy.TravelByPlane;
import classes.strategy.TravelByTrain;
import classes.strategy.TravelContext;
import classes.strategy.TravelNotIncluded;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
	private Label destinationLabel;
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
	private Stage primaryStage = new Stage();

	private ObservableList<String> rooms = FXCollections.observableArrayList("Single room", "Double room", "Apartment");
	private ObservableList<String> facilities = FXCollections.observableArrayList("Basic", "All inclusive", "Ultra all inclusive");
	private ObservableList<String> travel = FXCollections.observableArrayList("Not included", "By plane", "By bus", "By train");
	private SafeProxyAccount safeAccount;
	public GraphicMethods graphicM = new GraphicMethods();
	private LocalDate inDate;
	private LocalDate outDate;
	private ERoomType chosenRoom;
	private String chosenFacility;
	private ETravelType travellingType;
	private Hotel hotel;
	private PackageOffer offer;
	private double finalPrice;

	public void setSafeAccount(SafeProxyAccount safeAccount)
	{
		this.safeAccount = safeAccount;
	}
	
	public void setHotel(Hotel hotel)
	{
		this.hotel=hotel;
	}

	public void setImageView(String uri)
	{
		Image image = new Image(uri,640,393,false, false);
		imageView = new ImageView();
		imageView.setImage(image);
	}
	
	public void initializeOfferDetail()
	{
		extraInfoText.appendText("Basic package facilities ( All included in base price ) \n");
		for(int i = 0; i< Utils.BASIC.size(); i++)
			extraInfoText.appendText("\t" + (String)Utils.BASIC.get(i).getKey()+"\n");
		
		extraInfoText.appendText("\nAll inclusive package facilities \n");
		for(int i = 0; i< Utils.ALLINCLUSIVE.size(); i++)
			extraInfoText.appendText("\t"+(String)Utils.ALLINCLUSIVE.get(i).getKey()+ " Price - "+Utils.ALLINCLUSIVE.get(i).getValue()+"\n");
		
		extraInfoText.appendText("\nUltra all inclusive package facilities \n");
		for(int i = 0; i< Utils.ULTRAALLINCLUSIVE.size(); i++)
			extraInfoText.appendText("\t" + (String)Utils.ULTRAALLINCLUSIVE.get(i).getKey()+ " Price - "+Utils.ULTRAALLINCLUSIVE.get(i).getValue()+"\n");
	}

	public void initializeComboBoxes()
	{
		roomCombo.setItems(rooms);
		facilitiesCombo.setItems(facilities);
		travelCombo.setItems(travel);

		roomCombo.setPromptText("Choose room type");
		roomCombo.setOnAction((ActionEvent ev) ->
		{
			chosenRoom = ERoomType.values()[roomCombo.getSelectionModel().getSelectedIndex()];
		});

		facilitiesCombo.setPromptText("Choose facilities type");
		facilitiesCombo.setOnAction((ActionEvent ev) ->
		{
			chosenFacility = facilitiesCombo.getSelectionModel().getSelectedItem().toString();
		});

		travelCombo.setPromptText("Choose travelling type");
		travelCombo.setOnAction((ActionEvent ev) ->
		{
			travellingType = ETravelType.values()[travelCombo.getSelectionModel().getSelectedIndex()];
		});
	}

	public void setView()
	{
		destinationLabel.setText(hotel.getName().toUpperCase()+"( "+hotel.getCity().getName()+" )");
		initializeComboBoxes();
		initializeOfferDetail();
		graphicM.isLoggedin(safeAccount, buttonLogout, accordion);
		pictureLabel.setGraphic(imageView);
	}
	
	@FXML
    private void calculatePrice(ActionEvent event)
	{
		inDate = checkinPicker.getValue();
		outDate = checkoutPicker.getValue();
		finalPrice=0;
		
		if(inDate == null)
			graphicM.showMyAlert("No check in date !", "  Please choose a date.");
		else
			if(outDate == null)
				graphicM.showMyAlert("No check out date !", "  Please choose a date.");
			else
			{
				if(inDate.equals(outDate))
					graphicM.showMyAlert("Equal dates !", "  Please choose different dates.");
				if(inDate.isAfter(outDate))
					graphicM.showMyAlert("Wrong dates !", "  Please choose check in date to be before check out date.");
				if(chosenRoom == null)
					graphicM.showMyAlert("No room type !", "  Please choose a room type.");
				else
					if(chosenFacility == null)
						graphicM.showMyAlert("No facility type !", "  Please choose a facility type.");
					else
						if(travellingType == null)
							graphicM.showMyAlert("No travelling type !", "  Please choose a travel type.");
						else 
						{		
							long nofDays = ChronoUnit.DAYS.between(inDate, outDate);
							
							Utils utils = new Utils();
							
							IPackageOfferBuilder builder = new PackageOfferBuilder();
							PackageOfferBuilderAgent agent = new PackageOfferBuilderAgent(builder);
							
							
							TravelContext travelContext = null;
							
							switch(travellingType)
							{
								case NotIncluded:
									travelContext = new TravelContext(new TravelNotIncluded());
									break;
								case Bus:
									travelContext = new TravelContext(new TravelByBus());
									break;
								case Plane:
									travelContext = new TravelContext(new TravelByPlane());
									break;
								case Train:
									travelContext = new TravelContext(new TravelByTrain());
									break;
									
							}
							travelContext.executeStrategy();
							
							IPackageLevel decorator = null;
							
							switch(chosenFacility)
							{
							case "Basic":
								decorator = new BasicPackageOffer();
								break;
							case "All inclusive":
								decorator = new AllInclusivePackageOfferDecorator(new BasicPackageOffer());
								break;
							case "Ultra all inclusive":
								decorator = new UltraAllInclusivePackageOfferDecorator(new BasicPackageOffer());
								break;
							default:
								break;
							}
							agent.Construct(chosenRoom, hotel, decorator, travelContext);
							
							offer = agent.GetResult();
						
							
							finalPrice += utils.calculatePrice(offer, nofDays);
							if(finalPrice>0)
								priceField.setText(Double.toString(finalPrice));
						}
			}
	}
	
	@FXML
    private void reserve(ActionEvent event)
	{
		
		if(safeAccount==null)
			graphicM.showMyAlert("Not logged in!", "  You must be logged in in order to make a reservation.");
		else
		{
			if(offer!=null && finalPrice>=0)
			{
				if(safeAccount.reserve())
				{
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/view/PaymentView.fxml"));
		  			Parent root;
					try 
					{
						root = (Parent)fxmlLoader.load();
						PaymentViewController controller = fxmlLoader.<PaymentViewController>getController();
						controller.setSafeAccount(safeAccount);
						controller.setFinalPrice(finalPrice);
						controller.setPackageOffer(offer);
		  				controller.setView();
		  				graphicM.setStage(primaryStage,root);
		  				graphicM.closeStage(event);
			  				
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
				else
					graphicM.showMyAlert("Not logged in!", "  You must be logged in in order to make a reservation.");
			}
			else
				graphicM.showMyAlert("No offer!", "  You must choose data for offer in order to make a reservation.");
		}
	}
	
	@FXML
    private void back(ActionEvent event)
	{
		graphicM.loadMainStage(primaryStage,safeAccount);
		graphicM.closeStage(event);
	}
	
	@FXML
    private void login(ActionEvent event)
	{
		safeAccount=graphicM.login(buttonLogout,accordion,usernameField,passwordField);
	}
	
	@FXML
    private void logout(ActionEvent event)
	{
		safeAccount=null;
		graphicM.logout(buttonLogout,accordion);
	}


}
