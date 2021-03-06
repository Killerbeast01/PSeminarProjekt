import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main extends Application {


    private static double[][] screenbounds = new double[5][2];
    private static int Rotation = 0;
    private static int StandbyRotation = 0;
    private static Controller controller;
    static File[] ordnerarray = null;
    static Logger lg;
    static int Fenster = 0;

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

    private static void ordnereinlesen() {

        int ordner = 0;
        File f = new File("model");
        try {
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

        } catch (Exception e) {
            lg.warning(e.toString() + "\n " + "Ordner 'Model' nicht gefunden!");
            System.exit(1);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        startup();
        lg.info("Erzeuge Controller;");
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Controller.fxml"));
        AnchorPane root = loader.load();
        controller = loader.getController();
        if (ordnerarray != null) {
            String[] modelStrings = new String[ordnerarray.length];
            for (int i = 0; i < modelStrings.length; i++) {
                modelStrings[i] = ordnerarray[i].getName();
            }
            controller.cbModelChecker.setItems(FXCollections.observableArrayList(modelStrings));
            controller.cbModelChecker.setDisable(true);
        } else {
            String[] err = new String[1];
            err[0] = "Keine Modelle vorhanden";
            controller.cbModelChecker.setItems(FXCollections.observableArrayList(err));

        }
        controller.btn_rotate_right.setDisable(true);
        controller.btn_rotate_left.setDisable(true);
        controller.btn_rotate_reset.setDisable(true);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hologramm_Steuerung");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        controller.cbModelChecker.focusTraversableProperty();


        resizecomponents(primaryStage);

        primaryStage.show();
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> resizecomponents(primaryStage));
        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> resizecomponents(primaryStage));

        lg.info("Controller erzeugt;");
        turnThread turnThread = new turnThread();
        System.out.println("auf Fenster warten...");
        while (Fenster != 4) {
            Thread.sleep(1500);
        }

        controller.cbModelChecker.setDisable(false);
        controller.btn_rotate_right.setDisable(false);
        controller.btn_rotate_left.setDisable(false);
        controller.btn_rotate_reset.setDisable(false);


        primaryStage.setX(0);
        primaryStage.setY(0);
        Thread.sleep(1000);
        primaryStage.setFullScreen(true);
        primaryStage.setX(0);
        primaryStage.setY(0);
        turnThread.start();
        showOnScreen(1, Object.frame);
        Object.frame.setLocation(1280,50);
        Objectright.frame.setLocation(2560, 50);
        Objectback.frame.setLocation(3840,50);
        Objectleft.frame.setLocation(5120,50);

        Thread.sleep(1000);
        Objectback.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        Objectleft.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        Objectright.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        Object.frame.setExtendedState(Frame.MAXIMIZED_BOTH);


        Object.frame.setVisible(true);
        Objectright.frame.setVisible(true);
        Objectleft.frame.setVisible(true);
        Objectback.frame.setVisible(true);


    }

    void printloc(Stage primaryStage) {

        System.out.println(primaryStage.getX() + " + " + primaryStage.getY());
    }

    //Actions;

    static void modelchange() {

        if (ordnerarray != null) {

            System.out.println("Neues Model wird angewählt");
            int feldnummer = controller.getCbModelChecker().getSelectionModel().getSelectedIndex();
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
    } //Anderung des Angezeigten Modells

    static void rotateleft() {
        if (ordnerarray != null) {
            Rotation += 1;
            turnThread.setT(0);
            System.out.print("Rotation um 1 erhöht --> ");
            System.out.println(Rotation);
            window.leftrotation();
        }

    } //Sorgt für die Rotation aller Objekte nach links

    static void rotateright() {
        if (ordnerarray != null) {
            Rotation -= 1;
            turnThread.setT(0);
            System.out.print("Rotation um 1 verkleinert --> ");
            System.out.println(Rotation);
            window.rightrotation();
        }

    } //Sorgt für die Rotation aller Objekte nach rechts

    static void rotatereset() {
        if (ordnerarray != null) {
            turnThread.setT(-5);

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
        }
    } //Resettet die Rotation aller Objekte

    static void rotate() {
        if (ordnerarray != null) {
            StandbyRotation -= 1;
            System.out.print("Rotation um 1 verkleinert --> ");
            System.out.println(StandbyRotation);
            window.standbyrotation();
        }

    } //Rotation nach 5 sec Standby

    private static void resizecomponents(Stage primaryStage) {

        double w = primaryStage.getWidth();
        double h = primaryStage.getHeight();
        System.out.println(w + " " + h);

        controller.cbModelChecker.setPrefHeight(h * 0.05);
        controller.cbModelChecker.setPrefWidth(w * 0.3);
        controller.cbModelChecker.setLayoutX(w * 0.33);
        controller.cbModelChecker.setLayoutY(h * 0.2);

        controller.btn_rotate_reset.setPrefHeight(h * 0.1);
        controller.btn_rotate_reset.setPrefWidth(w * 0.3);
        controller.btn_rotate_reset.setLayoutX(w * 0.33);
        controller.btn_rotate_reset.setLayoutY(h * 0.5);

        controller.arrowleft.setFitHeight(h * 0.5);
        controller.arrowleft.setFitWidth(w * 0.25);
        controller.arrowleft.setLayoutX(w * 0.1);
        controller.arrowleft.setLayoutY(h * 0.2);

        controller.btn_rotate_left.setPrefHeight(h * 0.5);
        controller.btn_rotate_left.setPrefWidth(w * 0.25);
        controller.btn_rotate_left.setLayoutX(w * 0.1);
        controller.btn_rotate_left.setLayoutY(h * 0.2);

        controller.arrowright.setFitHeight(h * 0.5);
        controller.arrowright.setFitWidth(w * 0.25);
        controller.arrowright.setLayoutX(w * 0.62);
        controller.arrowright.setLayoutY(h * 0.2);

        controller.btn_rotate_right.setPrefHeight(h * 0.5);
        controller.btn_rotate_right.setPrefWidth(w * 0.25);
        controller.btn_rotate_right.setLayoutX(w * 0.62);
        controller.btn_rotate_right.setLayoutY(h * 0.2);


    } //Anpassung der Knöpfe an die Größe des Fensters


    public static void showOnScreen(int screen, Frame frame) {

        GraphicsDevice[] gds = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

        for (GraphicsDevice gd : gds) {
            //0 = x, 1 = y
            for (GraphicsConfiguration gc : gd.getConfigurations()) {
                Rectangle Bounds = gc.getBounds();
                if (screenbounds[0][0] == 0){ screenbounds[0][0] = Bounds.getX(); screenbounds[0][1] = Bounds.getY();}
                else if (screenbounds[1][0] == 0){ screenbounds[1][0] = Bounds.getX(); screenbounds[1][1] = Bounds.getY();}
                else if (screenbounds[2][0] == 0){ screenbounds[2][0] = Bounds.getX(); screenbounds[2][1] = Bounds.getY();}
                else if (screenbounds[3][0] == 0){ screenbounds[3][0] = Bounds.getX(); screenbounds[3][1] = Bounds.getY();}
                else if (screenbounds[4][0] == 0){ screenbounds[4][0] = Bounds.getX(); screenbounds[4][1] = Bounds.getY();}

                }

        }

        System.out.println(screenbounds[2][0] + " + " + screenbounds[2][1] );


    }
}

