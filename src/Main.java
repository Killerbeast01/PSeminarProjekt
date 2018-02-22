import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    private static int Rotation = 0;


    public static void main (String[] args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {


        Label label1 = new Label("Controller:");
        primaryStage.setTitle("Controller");

        //Buttons
        Button Rotate_Left = new Button("Rotate Left");
        Button Rotate_Right = new Button("Rotate Right");
        Button Altes_Schulgebauede = new Button("Altes Schulgebäude");
        Button Aktuelles_Schulgebaude = new Button("Aktuelles Schulgebäude");
        Button Otto_Hahn = new Button("Otto Hahn");
        Button ladybird = new Button("ladybird");

        ladybird.setOnAction(event -> {System.out.println("ladybird");
            Ladybird.loadladybird();
        });

        //Actions
        Rotate_Left.setOnAction(event -> {Rotation += 1;
            System.out.print("Rotation um 1 erhöht --> ");
            System.out.println(Rotation);
        });
        Rotate_Right.setOnAction(event -> {Rotation -= 1;
            System.out.print("Rotation um 1 verkleinert --> ");
            System.out.println(Rotation);
        });

        //windows

        Altes_Schulgebauede.setOnAction(event -> {System.out.println("Altes Schulgebäude");
            new window("front", "old_school");
            new window("right", "old_school");
            new window("back", "old_school");
            new window("left", "old_school");
        });

        Aktuelles_Schulgebaude.setOnAction(event -> {System.out.println("Aktuelles Schulgebäude");
            new window("front", "recent_school");
            new window("right", "recent_school");
            new window("back", "recent_school");
            new window("left", "recent_school");
        });

        Otto_Hahn.setOnAction(event -> {System.out.println("Otto Hahn");
            new window("front", "otto_hahn");
            new window("right", "otto_hahn");
            new window("back", "otto_hahn");
            new window("left", "otto_hahn");
        });


        Stage frame;
        frame = primaryStage;
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, Rotate_Left, Rotate_Right, Altes_Schulgebauede, Aktuelles_Schulgebaude, Otto_Hahn, ladybird);
        layout1.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout1, 200, 500);
        frame.setScene(scene);
        frame.setTitle("Controller");
        frame.show();


    }
}

