class window {

    window() {

            Thread obj1 = new Thread(new hilfclassethread(1));
            Thread obj2 = new Thread(new hilfclassethread(2));
            Thread obj3 = new Thread(new hilfclassethread(3));
            Thread obj4 = new Thread(new hilfclassethread(4));
            obj1.start();
            obj2.start();
            obj3.start();
            obj4.start();

    } //Startet die Fenster in Threads, damit es nicht so lange dauert

    //Rotation;
    static void rightrotation() {

        Object.turnleft();
        Objectback.turnleft();
        Objectleft.turnleft();
        Objectright.turnleft();

    } //Dreht alle Objekte nach rechts

    static void leftrotation(){

        Object.turnright();
        Objectback.turnright();
        Objectleft.turnright();
        Objectright.turnright();

    } //Dreht alle Objekte nach links

}
