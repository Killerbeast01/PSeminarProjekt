class window {

    window() {

        if (Main.ordnerarray != null) {

            Main.lg.info("Starte Threads für Fenster;");
            Thread obj1 = new Thread(new hilfclassethread(1));
            Thread obj2 = new Thread(new hilfclassethread(2));
            Thread obj3 = new Thread(new hilfclassethread(3));
            Thread obj4 = new Thread(new hilfclassethread(4));
            obj1.start();
            obj2.start();
            obj3.start();
            obj4.start();
            Main.lg.info("Threads für Fenster gestartet;");
        }

    } //Startet die Fenster in Threads, damit es nicht so lange dauert

    //Rotation;
    static void rightrotation() {
        if (Main.ordnerarray != null) {
            Object.turnleft();
            Objectback.turnleft();
            Objectleft.turnleft();
            Objectright.turnleft();
        }

    } //Dreht alle Objekte nach rechts

    static void leftrotation(){
        if (Main.ordnerarray != null) {
            Object.turnright();
            Objectback.turnright();
            Objectleft.turnright();
            Objectright.turnright();
        }

    } //Dreht alle Objekte nach links

    static void standbyrotation() {
        if (Main.ordnerarray != null) {
            Object.standbyrotate();
            Objectback.standbyrotate();
            Objectleft.standbyrotate();
            Objectright.standbyrotate();
        }
    }

    static void standbyrotationreverse() {
        if (Main.ordnerarray != null) {
            Object.standbyrotatereverse();
            Objectback.standbyrotatereverse();
            Objectleft.standbyrotatereverse();
            Objectright.standbyrotatereverse();
        }
    }

    static void zoomin() {
        if (Main.ordnerarray != null) {
            Object.zoomin();
            Objectback.zoomin();
            Objectleft.zoomin();
            Objectright.zoomin();

        }
    }

    static void zoomout() {
        if (Main.ordnerarray != null) {
            Object.zoomout();
            Objectback.zoomout();
            Objectleft.zoomout();
            Objectright.zoomout();
        }
    }


}
