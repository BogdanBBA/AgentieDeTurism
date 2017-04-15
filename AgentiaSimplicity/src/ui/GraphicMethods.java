package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class GraphicMethods 
{
	public void closeStage(ActionEvent event)
	{
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	public void showAlert(String headerText,String message)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText(headerText);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public void loadStage(String resource,int width,int height) throws Exception
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root,width,height);
		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		Stage primaryStage=new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	

}
