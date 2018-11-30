import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main extends Application {

    private static int Rotation = 0;
    private static int StandbyRotation =0;
    private static Controller controller;
    static File[] ordnerarray;
                static String old_school_path = "model/old_school/old_school.obj";
                static String recent_school_path = "model/recent_school/recent_school.obj";
                static String otto_hahn_path = "model/otto_hahn/otto_hahn.obj";
    static Logger lg;

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
        ordnereinlesen();
        new window();

    } //Startet automatisch alle Fenster, die das alte Schulgebäude anzeigen


    @Override
    public void start(Stage primaryStage) throws Exception{

        startup();
        lg.info("Erzeuge Controller;");
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Controller.fxml"));

        AnchorPane root = loader.load();


            String[] modelStrings = new String[ordnerarray.length];
            for (int i=0; i < modelStrings.length; i++) {
                modelStrings[i] = ordnerarray[i].getName();
            }
            controller = loader.getController();
            controller.cbModelChecker.setItems(FXCollections.observableArrayList(modelStrings));


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hologramm_Steuerung");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        lg.info("Controller erzeugt;");
        turnThread turnThread = new turnThread();
        turnThread.start();

    }

    private static void ordnereinlesen() {

        int ordner = 0;
        File f = new File("model");
        File[] modelArray = f.listFiles();
        assert modelArray != null;
        for (File aModelArray : modelArray) { //Anzahl der Ordner in "model" festgelegt

            if (aModelArray.isDirectory()) {
                ordner += 1;
            }

        }
        if (ordner == 0) {
            return;
        } //Falls keine Ordner in dem "model"Ordner sind
        ordnerarray = new File[ordner];
        int x = 0;
        for (File aModelArray : modelArray) { //Ordner in Array einlesen

            if (aModelArray.isDirectory()) {
                ordnerarray[x] = aModelArray;
                x = x + 1;
            }

        }

        for (File anOrdnerarray : ordnerarray) {
            System.out.println(anOrdnerarray.getName());
        }

    }

    //Actions;
    static void rotateleft() {
            Rotation += 1;
            turnThread.setT(0);
            System.out.print("Rotation um 1 erhöht --> ");
            System.out.println(Rotation);
            window.leftrotation();

        } //Sorgt für die Rotation aller Objekte nach links

    static void rotateright() {
            Rotation -= 1;
            turnThread.setT(0);
            System.out.print("Rotation um 1 verkleinert --> ");
            System.out.println(Rotation);
            window.rightrotation();

        } //Sorgt für die Rotation aller Objekte nach rechts

    static void rotatereset() {
        turnThread.setT(0);

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

        if (StandbyRotation != 0) {

            for (int i = 0; i > StandbyRotation; i--) {
                window.standbyrotationreverse();
            }

        }

        StandbyRotation = 0;
        Rotation = 0;
    } //Resettet die Rotation aller Objekte

    static void modelchange() {

        System.out.println("Neues Model wird angewählt");
        int feldnummer = controller.cbModelChecker.getSelectionModel().getSelectedIndex();
        String modelname = ordnerarray[feldnummer].getName();

        for (int i = 0; i < ordnerarray.length; i++) {
            if (ordnerarray[i].getName().equals(modelname)) {

                Object.applets[i].setVisible(true);
                Dimension size = Object.frame.getSize();
                Object.frame.add(Object.applets[i]);
                Object.frame.pack();
                Object.frame.setSize(size);

                Objectback.applets[i].setVisible(true);
                Dimension sizeback = Objectback.frame.getSize();
                Objectback.frame.add(Objectback.applets[i]);
                Objectback.frame.pack();
                Objectback.frame.setSize(sizeback);

                Objectright.applets[i].setVisible(true);
                Dimension sizeright = Objectright.frame.getSize();
                Objectright.frame.add(Objectright.applets[i]);
                Objectright.frame.pack();
                Objectright.frame.setSize(sizeright);

                Objectleft.applets[i].setVisible(true);
                Dimension sizeleft = Objectleft.frame.getSize();
                Objectleft.frame.add(Objectleft.applets[i]);
                Objectleft.frame.pack();
                Objectleft.frame.setSize(sizeleft);


            } else {



                Object.applets[i].setVisible(false);
                Objectback.applets[i].setVisible(false);
                Objectleft.applets[i].setVisible(false);
                Objectright.applets[i].setVisible(false);



            }
        }

    }

    public static void rotate() {
        StandbyRotation -= 1;
        System.out.print("Rotation um 1 verkleinert --> ");
        System.out.println(StandbyRotation);
        window.standbyrotation();
    }


}

