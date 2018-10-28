import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main extends Application {

    private static int Rotation = 0;
    static String old_school_path = "model/old_school/ladybird2_w.obj";
    static String recent_school_path = "model/recent_school/recent_school_w.obj";
    static String otto_hahn_path = "model/otto_hahn/IronMan.obj";
    protected static Logger lg;

    public static void main(String[] args) {

        launch(args);

    }

    //Startup
    private static void startup() {
        lg = Logger.getLogger("Logger");
        FileHandler fh;
        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("Log.log");
            lg.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        lg.setUseParentHandlers(false);
        lg.info("Start;");
        new window();

    } //Startet automatisch alle Fenster, die das alte Schulgebäude anzeigen


    @Override
    public void start(Stage primaryStage) throws Exception{

        startup();
        lg.info("Erzeuge Controller;");
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Controller.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hologramm_Steuerung");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        lg.info("Controller erzeugt;");


    }


    //Actions;
    static void rotateleft() {
            Rotation += 1;
            System.out.print("Rotation um 1 erhöht --> ");
            System.out.println(Rotation);
            window.leftrotation();

        } //Sorgt für die Rotation aller Objekte nach links

    static void rotateright() {
            Rotation -= 1;
            System.out.print("Rotation um 1 verkleinert --> ");
            System.out.println(Rotation);
            window.rightrotation();

        } //Sorgt für die Rotation aller Objekte nach rechts

    static void rotatereset() {


        if (Rotation != 0) {
            if (Rotation > 0) {
                int i = 0;
                System.out.println("reset " + Rotation);
                for (; i < Rotation; i++) {
                    window.rightrotation();
                }
            } else {
                System.out.println("reset " + Rotation);
                int i = 0;
                for (; i > Rotation; i--) {
                    System.out.println("starte reset" + i);
                    window.leftrotation();

                }

            }
        }
        Rotation = 0;
    } //Resettet die Rotation aller Objekte

    //Windows;
    static void showoldschool() {

    Object.applet_old.setVisible(true);
    Object.applet_otto.setVisible(false);
    Object.applet_recent.setVisible(false);

    Objectback.applet_old.setVisible(true);
    Objectback.applet_otto.setVisible(false);
    Objectback.applet_recent.setVisible(false);

    Objectleft.applet_old.setVisible(true);
    Objectleft.applet_otto.setVisible(false);
    Objectleft.applet_recent.setVisible(false);

    Objectright.applet_old.setVisible(true);
    Objectright.applet_otto.setVisible(false);
    Objectright.applet_recent.setVisible(false);

    } //Zeigt in allen Fenstern das alte Schulgebäude an

    static void showrecentschool() {

        Object.applet_old.setVisible(false);
        Object.applet_otto.setVisible(false);
        Object.applet_recent.setVisible(true);
        Dimension size = Object.frame.getSize();
        Object.frame.add(Object.applet_recent);
        Object.frame.pack();
        Object.frame.setSize(size);

        Objectback.applet_old.setVisible(false);
        Objectback.applet_otto.setVisible(false);
        Objectback.applet_recent.setVisible(true);
        Dimension sizeback = Objectback.frame.getSize();
        Objectback.frame.add(Objectback.applet_recent);
        Objectback.frame.pack();
        Objectback.frame.setSize(sizeback);

        Objectleft.applet_old.setVisible(false);
        Objectleft.applet_otto.setVisible(false);
        Objectleft.applet_recent.setVisible(true);
        Dimension sizeleft = Objectleft.frame.getSize();
        Objectleft.frame.add(Objectleft.applet_recent);
        Objectleft.frame.pack();
        Objectleft.frame.setSize(sizeleft);

        Objectright.applet_old.setVisible(false);
        Objectright.applet_otto.setVisible(false);
        Objectright.applet_recent.setVisible(true);
        Dimension sizeright = Objectright.frame.getSize();
        Objectright.frame.add(Objectright.applet_recent);
        Objectright.frame.pack();
        Objectright.frame.setSize(sizeright);

    } //Zeigt in allen Fenstern das aktuelle Schulgebäude an

    static void showottohahn() {

        Object.applet_old.setVisible(false);
        Object.applet_otto.setVisible(true);
        Object.applet_recent.setVisible(false);
        Dimension size = Object.frame.getSize();
        Object.frame.add(Object.applet_otto);
        Object.frame.pack();
        Object.frame.setSize(size);

        Objectback.applet_old.setVisible(false);
        Objectback.applet_otto.setVisible(true);
        Objectback.applet_recent.setVisible(false);
        Dimension sizeback = Objectback.frame.getSize();
        Objectback.frame.add(Objectback.applet_otto);
        Objectback.frame.pack();
        Objectback.frame.setSize(sizeback);

        Objectleft.applet_old.setVisible(false);
        Objectleft.applet_otto.setVisible(true);
        Objectleft.applet_recent.setVisible(false);
        Dimension sizeleft = Objectleft.frame.getSize();
        Objectleft.frame.add(Objectleft.applet_otto);
        Objectleft.frame.pack();
        Objectleft.frame.setSize(sizeleft);

        Objectright.applet_old.setVisible(false);
        Objectright.applet_otto.setVisible(true);
        Objectright.applet_recent.setVisible(false);
        Dimension sizeright = Objectright.frame.getSize();
        Objectright.frame.add(Objectright.applet_otto);
        Objectright.frame.pack();
        Objectright.frame.setSize(sizeright);

    } //Zeigt in allen Fenstern die Büste von Otto Hahn an

}

