package ui.controller;

import classes.proxy.SafeProxyAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.GraphicMethods;

public class PaymentViewController 
{
	@FXML
	private Pane leftPane;
	@FXML
	private ScrollPane scroll;
	@FXML
	private VBox v;
	@FXML
	private BorderPane border;
	
	private Stage primaryStage=new Stage();
	private SafeProxyAccount safeAccount;
	public GraphicMethods graphicM=new GraphicMethods();
	
	public void setSafeAccount(SafeProxyAccount safeAccount) 
	{
		this.safeAccount = safeAccount;
	}
	
	public void initializeReservation(VBox v,ScrollPane scrollPane)
	{
		Label l=new Label();
		l.setText("dasvhgsfd");
		l.setMinWidth(v.getPrefWidth());
		v.getChildren().add(l);
	}
	
	public void setView()
	{
		v = new VBox();
	    v.setAlignment(Pos.TOP_RIGHT);
	    v.setSpacing(20);
	    v.setPrefSize(640, 671);
	    leftPane.setPrefWidth(1024-955);
	    
	    ScrollPane scrollPane = new ScrollPane(v);
	    scrollPane.setFitToHeight(true);
	    scrollPane.setMaxWidth(655);
	    initializeReservation(v,scrollPane);
	    border.setCenter(scrollPane);
	}
	
	@FXML
    private void back(ActionEvent event)
	{
		
	}
	
	@FXML
    private void logout(ActionEvent event)
	{
		graphicM.loadMainStage(primaryStage);
		graphicM.closeStage(event);
	}
}
