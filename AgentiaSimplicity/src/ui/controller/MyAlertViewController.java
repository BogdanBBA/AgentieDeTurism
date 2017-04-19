package ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MyAlertViewController
{
	@FXML
	private Label headerText;
	@FXML
	private TextArea messageText;

	public void setTexts(String header, String message)
	{
		headerText.setText(header);
		messageText.setText(message);
	}

}
