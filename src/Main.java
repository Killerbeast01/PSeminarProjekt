
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//erzeugt Frame als ControllerFenster zur Steuerung des Hologramms;
public class Main implements MouseListener {

    private static int Rotation = 0;
    static Controller mycontroller;
    static String objectpath = "model/old_school/ladybird2_w.obj";
    static String objectpathnew = "model/recent_school/recent_school_w.obj";
    static Object object;



    public static void main (String[] args){

        mycontroller = new Controller();
        System.out.println("controller startet");
        Thread object = new Thread(new go(1));
        System.out.println("thread startet");
        Thread object2 = new Thread(new go(2));
        Thread object3 = new Thread(new go(3));
        Thread object4 = new Thread(new go(4));
        Thread object5 = new Thread(new go(5));
        Thread object6 = new Thread(new go(6));
        Thread object7 = new Thread(new go(7));
        Thread object8 = new Thread(new go(8));
        object.start();
        System.out.println("thread gestartet");
        object2.start();
        object3.start();
        object4.start();
        System.out.println("thread 4 start");
        object5.start();
        object6.start();
        object7.start();
        object8.start();


    }

    //Actions;
        public static void rotateleft() {
            Rotation += 1;
            System.out.print("Rotation um 1 erhöht --> ");
            System.out.println(Rotation);
            window.leftrotation();

        }

        public static void rotateright() {
            Rotation -= 1;
            System.out.print("Rotation um 1 verkleinert --> ");
            System.out.println(Rotation);
            window.rightrotation();

        }

        //Windows;
        public static void showoldschool() {
            System.out.println("Altes Schulgebäude");
            Object.frame.setVisible(true);
            Objectback.frame.setVisible(true);
            Objectright.frame.setVisible(true);
            Objectleft.frame.setVisible(true);
            Objectnew.frame.setVisible(false);
            Objectbacknew.frame.setVisible(false);
            Objectrightnew.frame.setVisible(false);
            Objectleftnew.frame.setVisible(false);

        }

        public static void showrecentschool() {
            System.out.println("Aktuelles Schulgebäude");
            Object.frame.setVisible(false);
            Objectback.frame.setVisible(false);
            Objectright.frame.setVisible(false);
            Objectleft.frame.setVisible(false);
            Objectnew.frame.setVisible(true);
            Objectbacknew.frame.setVisible(true);
            Objectrightnew.frame.setVisible(true);
            Objectleftnew.frame.setVisible(true);


        }

        public static void showottohahn() {
            System.out.println("Otto Hahn");


        }

        public static void rotatereset() {


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

