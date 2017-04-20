package ui.controller;

import java.time.LocalDate;
import java.util.List;
import classes.model.Hotel;
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
	private List<String> list;
	private Hotel hotel;
	private LocalDate inDate;
	private long nrDays;

	public void setList(List<String> list) 
	{
		this.list = list;
	}

	public void setSafeAccount(SafeProxyAccount safeAccount) 
	{
		this.safeAccount = safeAccount;
	}
	
	public void setHotel(Hotel hotel)
	{
		this.hotel=hotel;
	}
	
	public void setCheckIn(LocalDate inDate)
	{
		this.inDate=inDate;
	}
	
	public void setDuration(long nofDays)
	{
		this.nrDays=nofDays;
	}
	
	public void setView()
	{
		detailsText.appendText("\nYour reservation details\n\n\n");
		detailsText.appendText("Location\n");
		detailsText.appendText("\t"+hotel.getName()+" ( "+hotel.getCity().getName()+" )\n\n");
		detailsText.appendText("Check-in date\n");
		detailsText.appendText("\t"+inDate+" \n\n");
		detailsText.appendText("Duration\n");
		detailsText.appendText("\t"+nrDays+"  days\n\n");
		detailsText.appendText("Facilities included\n");
		for(int i=0;i<list.size();i++)
			detailsText.appendText(list.get(i)+"\n");
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
