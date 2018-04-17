package tp1PlacementWidgets;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SimpleScene extends Application {
	public void start ( Stage stage ) {
		VBox root = new VBox ();
		Label msg = new Label ("Hello ␣ JavaFX");
		root.getChildren().add (msg);
		
		Scene scene = new Scene(root, 300, 50);
		stage.setScene(scene);
		stage.setTitle("Hello ␣ JavaFX ");
//		stage.setFullScreen(true);
//		stage.initStyle(StageStyle.UNDECORATED);
//		stage.setResizable(false);
//		stage.initOwner();
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
