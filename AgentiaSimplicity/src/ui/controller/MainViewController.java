package ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import classes.Database;
import classes.iterator.IIterator;
import classes.iterator.StandardIterable;
import classes.model.Hotel;
import classes.proxy.SafeProxyAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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
	private ScrollPane scrollPane;

	private Stage primaryStage = new Stage();
	private SafeProxyAccount safeAccount;
	public GraphicMethods graphicM = new GraphicMethods();
	private ObservableList<String> accomodations = FXCollections.observableArrayList("Hotel", "Motel", "Inns", "Guesthouse");
	private int chosenAccomodation;

	public void setSafeAccount(SafeProxyAccount safeAcc)
	{
		this.safeAccount = safeAcc;
	}

	public void initializeListOfOffers(VBox v, ScrollPane scrollPane,ArrayList<Hotel> hotels)
	{
		IIterator iterator = new StandardIterable().getIterator(hotels);
		while (iterator.moveNext())
		{
			Hotel hotel = (Hotel) iterator.current();
			String imageUri = String.format("/ui/images/hotel%d.png", hotel.getId());
			Image image = new Image(imageUri);
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			Button button = new Button(String.format("%s (%s)", hotel.getName().toUpperCase(), hotel.getCity().getName()), imageView);
			button.setId(Integer.toString(hotel.getId()));
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
						root = (Parent) fxmlLoader.load();
						OfferViewController controller = fxmlLoader.<OfferViewController>getController();
						controller.setImageView(imageUri);
						controller.setHotel(hotel);
						controller.setSafeAccount(safeAccount);
						controller.setView();
						graphicM.setStage(primaryStage,root);
		  				graphicM.closeStage(event);

					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			});

			button.setMinWidth(v.getPrefWidth());
			v.getChildren().add(button);
		}
	}

	public void initializeComboBox()
	{
		accomodationCombo.setItems(accomodations);

		accomodationCombo.setPromptText("Choose accomodation type");
		accomodationCombo.setOnAction((ActionEvent ev) ->
		{
			chosenAccomodation = accomodationCombo.getSelectionModel().getSelectedIndex();
			System.out.println(chosenAccomodation);
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
		leftPane.setPrefWidth(1024 - 955);

		scrollPane = new ScrollPane(v);
		scrollPane.setFitToHeight(true);
		scrollPane.setMaxWidth(655);
		initializeListOfOffers(v, scrollPane, Database.getInstance().getHotels());
		border.setCenter(scrollPane);
	}

	@FXML
	private void search(ActionEvent event)
	{
		String destination = destinationField.getText();


		if (destination.isEmpty() && chosenAccomodation <0)
		{
			graphicM.showMyAlert("No search criteria!", "  Please enter the criteria needed for search.");
		}
		else
		{
			v.getChildren().clear();
			initializeListOfOffers(v, scrollPane, Database.getInstance().searchHotels(destination, chosenAccomodation));
		}
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