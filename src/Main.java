import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.concurrent.ExecutionException;


public class Main extends Application {

    int Rotation = 0;

    public static void main (String[] args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;

        Label label1 = new Label("Controller:");
        primaryStage.setTitle("Controller");

        //Bottons
        Button Rotate_Left = new Button("Rotate Left");
        Button Rotate_Right = new Button("Rotate Right");
        Button Altes_Schulgebauede = new Button("Altes Schulgebäude");
        Button Aktuelles_Schulgebaude = new Button("Aktuelles Schulgebäude");
        Button Otto_Hahn = new Button("Otto Hahn");
        Button RotationAnzeiger = new Button("Rotation:");

        //Actions
        Rotate_Left.setOnAction(event -> Rotation += 1);
        Rotate_Right.setOnAction(event -> Rotation -= 1);
        Altes_Schulgebauede.setOnAction(event -> System.out.println("Altes Schulgebäude"));
        Aktuelles_Schulgebaude.setOnAction(event -> System.out.println("Aktuelles Schulgebäude"));
        Otto_Hahn.setOnAction(event -> System.out.println("Otto Hahn"));
        RotationAnzeiger.setOnAction(event -> System.out.println("Rotation: " + Rotation));


        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, Rotate_Left, Rotate_Right, Altes_Schulgebauede, Aktuelles_Schulgebaude, Otto_Hahn, RotationAnzeiger);
        layout1.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout1, 200, 500);
        window.setScene(scene);
        window.setTitle("Controller");
        window.show();


    }
}
