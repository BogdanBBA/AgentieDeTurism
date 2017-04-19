package ui;

import classes.Database;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	public GraphicMethods graphicM = new GraphicMethods();

	@Override
	public void start(Stage primaryStage)
	{
		graphicM.loadMainStage(primaryStage);
	}

	public static void main(String[] args)
	{
		Database.getInstance().readFromDatabase();
		launch(args);
	}
}
