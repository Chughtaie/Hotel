package cafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App6 extends Application
{
	//Inside the main() method, we can launch our application using Application.launch().
	public static void main(String[] args) 
	{
		launch(args);
	}

	public static Stage pStage;

	public void start(Stage primaryStage) 
	{
		
		try 
		{
			pStage = primaryStage;
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,450,450);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			pStage.setScene(scene);
			pStage.setTitle("CAFE");
			pStage.show();
			//primaryStage.setMaximized(true);
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}