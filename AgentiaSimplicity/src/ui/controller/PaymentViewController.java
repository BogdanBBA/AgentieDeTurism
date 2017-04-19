package ui.controller;

import classes.builder.PackageOffer;
import classes.proxy.SafeProxyAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ui.GraphicMethods;

public class PaymentViewController 
{
	@FXML
	private TextArea detailsText;
	
	private Stage primaryStage=new Stage();
	private SafeProxyAccount safeAccount;
	public GraphicMethods graphicM=new GraphicMethods();
	private PackageOffer offer;
	private double finalPrice;
	
	public void setSafeAccount(SafeProxyAccount safeAccount) 
	{
		this.safeAccount = safeAccount;
	}
	
	public void setPackageOffer(PackageOffer offer) 
	{
		this.offer = offer;
	}
	
	public void setFinalPrice(double finalPrice) 
	{
		this.finalPrice = finalPrice;
	}
	
	public void setView()
	{
		detailsText.appendText("\n");
		offer.getPackageLevel().Display(detailsText);
		detailsText.appendText("\n\n\nTotal cost:   "+finalPrice);
	}
	
	@FXML
    private void back(ActionEvent event)
	{
		graphicM.loadMainStage(primaryStage,safeAccount);
		graphicM.closeStage(event);
	}
	
	@FXML
    private void logout(ActionEvent event)
	{
		safeAccount=null;
		graphicM.loadMainStage(primaryStage,safeAccount);
		graphicM.closeStage(event);
	}
}
