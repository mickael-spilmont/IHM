package tp3Widgets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonsAndLabel extends Application {
	Label label;
	Button bmoins, bplus;
	int x, y, currentValue;

	class ClicListenerIncDec implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			int currentValue = Integer.parseInt(label.getText());
			if (event.getTarget() == bplus) {
				label.setText("" + (currentValue + 1));
			} else {
				label.setText("" + (currentValue - 1));
			}
		}
	}

	public void start(Stage stage) {
		label = new Label("0");
		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		label.setStyle("-fx-background-color: lightblue;"
				+ " -fx-alignment: center;"
				+ " -fx-font: 30px Verdana;");
		bmoins = new Button("  -  ");
		bplus = new Button("  +  ");

		bplus.addEventHandler(ActionEvent.ACTION, new ClicListenerIncDec());
		bmoins.addEventHandler(ActionEvent.ACTION, new ClicListenerIncDec());

//		prise en charge du clic droit et gauche
		
		label.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
			x = (int) e.getX();
			y = (int) e.getY();
			currentValue = Integer.parseInt(label.getText());
			if (e.isPrimaryButtonDown()) {
				label.setText("" + (currentValue + 1));
			}
			else {
				label.setText("" + (currentValue - 1));
			}
		});
		
//		Prise en charge du drag
		
		label.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
			label.setText(""  + (currentValue + ((int) e.getX() - x) / 10)); // la division sert à ajuster la vitesse
		});

//		Mise en place de la scene
		
		VBox vbox = new VBox(3);
		vbox.setPadding(new Insets(3, 3, 3, 3));
		vbox.setAlignment(Pos.CENTER);
		HBox hbox = new HBox(3);
		hbox.getChildren().addAll(bmoins, bplus);
		vbox.getChildren().addAll(label, hbox);

		Scene scene = new Scene(vbox);
		stage.setTitle("Counter");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
