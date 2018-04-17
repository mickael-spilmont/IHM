package tp2Canvas;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class HelloPaint extends Application {

	private Canvas canvas;
	private GraphicsContext gc;
	private ArrayList<Rectangle> listeRectangles;
	
	private class MyMouseEventHandler implements EventHandler<MouseEvent>{
		public void handle (MouseEvent event) {
			if (event.isShiftDown()) {
				 for (int i = 0 ; i < listeRectangles.size() ; i++) {
					 if (listeRectangles.get(i).contains(event.getX() -10, event.getSceneY() -10)) {
						 listeRectangles.remove(i);
					 }
				 }
			}
			
			gc.setFill(Color.BLACK);
			gc.fillRect(event.getX() - 10, event.getY() - 10, 20, 20);
			gc.setStroke(Color.GREY);
			gc.strokeRect(event.getX() - 10, event.getY() - 10, 20, 20);
			listeRectangles.add(new Rectangle(event.getX() - 10, event.getY() - 10, 20, 20));
		}
	}

	public void start(Stage stage) {
		listeRectangles = new ArrayList<>();
		
		VBox root = new VBox();
		canvas = new Canvas(300, 300);
		gc = canvas.getGraphicsContext2D();
		
		MyMouseEventHandler h = new MyMouseEventHandler();
		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, h);
		
		root.getChildren().add(canvas);

		Scene scene = new Scene(root);
		stage.setTitle("Hello Paint");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}