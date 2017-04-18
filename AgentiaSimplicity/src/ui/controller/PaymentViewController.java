package ui.controller;

import classes.proxy.SafeProxyAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ui.GraphicMethods;

public class PaymentViewController 
{
	private Stage primaryStage=new Stage();
	private SafeProxyAccount safeAccount;
	public GraphicMethods graphicM=new GraphicMethods();
	
	public void setSafeAccount(SafeProxyAccount safeAccount) 
	{
		this.safeAccount = safeAccount;
	}
	
	public void setView()
	{
		
	}
	
	@FXML
    private void logout(ActionEvent event)
	{
		graphicM.loadMainStage(primaryStage);
		graphicM.closeStage(event);
	}
}
