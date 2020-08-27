package controller;

/* 
 * Run Configurations:
 * --module-path /Users/jarounger/Desktop/Java/javafx-sdk-14.0.1/lib --add-modules javafx.controls,javafx.fxml
 * 
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KontaktMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/KontaktView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Kontakt App");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
		e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
