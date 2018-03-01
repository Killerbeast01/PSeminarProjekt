import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//erzeugt Frame als ControllerFenster zur Steuerung des Hologramms;
public class Main extends Application implements MouseListener {

    private static int Rotation = 0;

    public static void main (String[] args){

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        Label label1 = new Label("Controller:");
        primaryStage.setTitle("Controller");

        //Buttons;
        Button rotate_Left = new Button("Rotate Left");
        Button Rotate_Right = new Button("Rotate Right");
        Button Altes_Schulgebauede = new Button("Altes Schulgebäude");
        Button Aktuelles_Schulgebaude = new Button("Aktuelles Schulgebäude");
        Button Otto_Hahn = new Button("Otto Hahn");

        //Actions;
        rotate_Left.setOnAction(event -> {
            Rotation += 1;
            System.out.print("Rotation um 1 erhöht --> ");
            System.out.println(Rotation);
            window.leftrotation();

        });

        Rotate_Right.setOnAction(event -> {
            Rotation -= 1;
            System.out.print("Rotation um 1 verkleinert --> ");
            System.out.println(Rotation);
            window.rightrotation();

        });

        //Windows;
        Altes_Schulgebauede.setOnAction(event -> {
            System.out.println("Altes Schulgebäude");
            new window("old_school");

        });

        Aktuelles_Schulgebaude.setOnAction(event -> {
            System.out.println("Aktuelles Schulgebäude");
            new window("recent_school");

        });

        Otto_Hahn.setOnAction(event -> {
            System.out.println("Otto Hahn");
            new window("otto_hahn");

        });

        //erzeuge Fenster mit Knöpfen (bisher ohne richtiges Layout;
        Stage frame;
        frame = primaryStage;
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, rotate_Left, Rotate_Right, Altes_Schulgebauede, Aktuelles_Schulgebaude, Otto_Hahn);
        layout1.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout1, 200, 500);
        frame.setScene(scene);
        frame.setTitle("Controller");
        frame.show();


    }

    //Vorreiter für Spätere implementation von längeren Clicks;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}

