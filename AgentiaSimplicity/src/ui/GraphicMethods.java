package ui;

import classes.model.User;
import classes.proxy.SafeProxyAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class GraphicMethods
{
	public void closeStage(ActionEvent event)
	{
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	public void showAlert(String headerText, String message)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText(headerText);
		alert.setContentText(message);
		alert.showAndWait();
	}

	public void loadStage(String resource, int width, int height) throws Exception
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root, width, height);
		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void isLoggedin(SafeProxyAccount safeAccount, Button buttonLogout, Accordion accordion)
	{
		if (safeAccount == null)
		{
			accordion.setVisible(true);
			buttonLogout.setVisible(false);
		} else
		{
			accordion.setVisible(false);
			buttonLogout.setVisible(true);
		}
	}

	public void login(SafeProxyAccount safeAccount, Button buttonLogout, Accordion accordion, TextField usernameField, PasswordField passwordField)
	{
		String username = usernameField.getText();
		String password = passwordField.getText();

		User user = new User(username, password);
		safeAccount = new SafeProxyAccount(user);

		if (!safeAccount.login(user))
		{
			safeAccount = null;
			showAlert("Login failed", "There is a problem with your username/password. Please try again");
		} else
		{
			usernameField.setText("");
			passwordField.setText("");
			accordion.setVisible(false);
			buttonLogout.setVisible(true);
		}
	}

	public void logout(SafeProxyAccount safeAccount, Button buttonLogout, Accordion accordion)
	{
		buttonLogout.setVisible(false);
		safeAccount = null;
		accordion.setVisible(true);
		accordion.getExpandedPane().setExpanded(false);
	}

}
