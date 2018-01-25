import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    int Rotation = 0;

    public static void main (String[] args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
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
        Rotate_Left.setOnAction(event -> {Rotation += 1;
            RotationAnzeiger.setText("Rotation: "+Rotation);
        });
        Rotate_Right.setOnAction(event -> {Rotation -= 1;
            RotationAnzeiger.setText("Rotation: "+Rotation);
        });

        Altes_Schulgebauede.setOnAction(event -> {System.out.println("Altes Schulgebäude");
            new Hologramm(0,"Altes Schulgebäude_Front");
            new Hologramm(90,"Altes Schulgebäude_Rechts");
            new Hologramm(180,"Altes Schulgebäude_Hinten");
            new Hologramm(270,"Altes Schulgebäude_Links");
        });
        Aktuelles_Schulgebaude.setOnAction(event -> {System.out.println("Aktuelles Schulgebäude");
            new Hologramm(0,"Aktuelles Schulgebäude_Front");
            new Hologramm(90,"Aktuelles Schulgebäude_Rechts");
            new Hologramm(180,"Aktuelles Schulgebäude_Hinten");
            new Hologramm(270,"Aktuelles Schulgebäude_Links");
        });
        Otto_Hahn.setOnAction(event -> {System.out.println("Otto Hahn");
            new Hologramm(0,"Otto_Hahn_Front");
            new Hologramm(90,"Otto_Hahn_Rechts");
            new Hologramm(180,"Otto_Hahn_Hinten");
            new Hologramm(270,"Otto_Hahn_Links");
        });
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

