package ui;

import classes.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			String readResult = Database.getInstance().readFromDatabase();
			if (!readResult.equals(""))
				System.err.println(readResult);
			else
				System.out.println("Database read successfully.");

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
