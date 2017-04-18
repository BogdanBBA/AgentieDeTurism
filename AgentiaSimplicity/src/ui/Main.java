package ui;

import ui.controller.MainViewController;
import classes.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			String readResult = Database.getInstance().readFromDatabase();
			if (!readResult.equals(""))
				System.err.println(readResult);
			else
				System.out.println("Database read successfully.");

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/view/MainView.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			MainViewController controller = fxmlLoader.<MainViewController>getController();
			controller.initialize();
			Scene scene = new Scene(root, 1024, 768);
			scene.getStylesheets().add(getClass().getResource("/ui/style/style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
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
