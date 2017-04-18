package ui.controller;

import classes.model.User;
import classes.proxy.SafeProxyAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
	private DatePicker checkinPicker;
	@FXML
	private DatePicker checkoutPicker;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField priceField;
	@FXML
	private TextField priceFacilitiesField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label destinationLabel;
	@FXML
	private Label pictureLabel;
	@FXML
	private TextArea basicInfoText;
	@FXML
	private TextArea extraInfoText;
	@FXML
	private ImageView imageView;
	private Stage primaryStage = new Stage();
	private SafeProxyAccount safeAccount;
	public GraphicMethods graphicM = new GraphicMethods();

	public OfferViewController()
	{

	}

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
		Image image = new Image(uri, 417, 398, false, false);
		imageView = new ImageView();
		imageView.setImage(image);
	}

	public void setView()
	{
		graphicM.isLoggedin(safeAccount, buttonLogout, accordion);
		imageView.setImage(new Image("/ui/images/mypic.jpg", 412, 393, false, false));
		pictureLabel.setGraphic(imageView);
	}

	@FXML
	private void reserve(ActionEvent event)
	{

	}

	@FXML
	private void login(ActionEvent event)
	{
		graphicM.login(safeAccount, buttonLogout, accordion, usernameField, passwordField);
	}

	@FXML
	private void logout(ActionEvent event)
	{
		graphicM.logout(safeAccount, buttonLogout, accordion);
	}

}
