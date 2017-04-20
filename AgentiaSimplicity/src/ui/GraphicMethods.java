package ui;

import java.io.IOException;
import classes.model.User;
import classes.proxy.SafeProxyAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.controller.MainViewController;
import ui.controller.MyAlertViewController;

public class GraphicMethods 
{
	public void closeStage(ActionEvent event)
	{
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	public void showMyAlert(String header,String message)
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/view/MyAlertView.fxml"));
		Parent root;
		try 
		{
			root = (Parent)fxmlLoader.load();
			MyAlertViewController controller = fxmlLoader.<MyAlertViewController>getController();
			controller.setTexts(header, message);
	        Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("/ui/style/style.css").toExternalForm());
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void setStage(Stage primaryStage,Parent root)
	{
	        Scene scene = new Scene(root,1024,768);
			scene.getStylesheets().add(getClass().getResource("/ui/style/style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

	}
	
	public void loadMainStage(Stage primaryStage,SafeProxyAccount safeAccount)
	{
		try 
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/view/MainView.fxml"));
			Parent root = (Parent)fxmlLoader.load();
			MainViewController controller = fxmlLoader.<MainViewController>getController();
			controller.setSafeAccount(safeAccount);
			controller.initialize();
			setStage(primaryStage,root);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public void isLoggedin(SafeProxyAccount safeAccount,Button buttonLogout,Accordion accordion)
	{
		if(safeAccount==null)
		{
			accordion.setVisible(true);
			buttonLogout.setVisible(false);
		}
		else
		{
			accordion.setVisible(false);
			buttonLogout.setVisible(true);
		}
	}
	
	public SafeProxyAccount login(Button buttonLogout,Accordion accordion,TextField usernameField,PasswordField passwordField)
	{
		SafeProxyAccount safeAccount;
		String username=usernameField.getText();
		String password=passwordField.getText();

		User user=new User(username,password);
		safeAccount=new SafeProxyAccount(user);
		
		if(!safeAccount.login(user))
		{
			safeAccount=null;
			showMyAlert("Login failed!", "  Username or password is wrong. Please try again");
		}
		else
		{
			usernameField.setText("");
			passwordField.setText("");
			accordion.setVisible(false);
			buttonLogout.setVisible(true);
		}
		return safeAccount;
	}
	
	
	public void logout(Button buttonLogout,Accordion accordion)
	{
		buttonLogout.setVisible(false);
		accordion.setVisible(true);
		accordion.getExpandedPane().setExpanded(false);
	}

}
