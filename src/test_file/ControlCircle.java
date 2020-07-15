package test_file;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
class CirclePane extends StackPane {
    private Circle circle = new Circle(50);
    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }
    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);
    }
    public void shrink() {
        circle.setRadius(circle.getRadius() > 2 ?
                circle.getRadius() - 2 : circle.getRadius());
    }
}



public class ControlCircle extends Application {
    private CirclePane circlePane = new CirclePane();
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
// Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10); // gap between buttons
        hBox.setAlignment(Pos.BOTTOM_LEFT);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);
// Create and register the handler
        btEnlarge.setOnAction(new EnlargeHandler());
        btShrink.setOnAction((ActionEvent) -> {
            circlePane.shrink();
        }); //using Lambda Expression
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
// Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle"); //Set the stage title
        primaryStage.setScene(scene); //Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            circlePane.enlarge();
        }
    }
}
