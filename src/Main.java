
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//erzeugt Frame als ControllerFenster zur Steuerung des Hologramms;
public class Main implements MouseListener {

    private static int Rotation = 0;
    static Controller mycontroller;


    public static void main (String[] args){

        mycontroller = new Controller();

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
            new window("old_school");

        }

        public static void showrecentschool() {
            System.out.println("Aktuelles Schulgebäude");
            new window("recent_school");

        }

        public static void showottohahn() {
            System.out.println("Otto Hahn");
            new window("otto_hahn");

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

