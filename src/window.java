class window {

    private static String objectpath;
    private static boolean already_created = false;

    window(String shownObject) {

        switch (shownObject) {

            case "old_school":
                objectpath = "model/old_school/ladybird2_w.obj";
                break;
            case "recent_school":
                objectpath = "model/recent_school/recent_school_w.obj";
                break;
            case "otto_hahn":
                objectpath = "model/otto_hahn/otto_hahn_w.obj";
                break;

        }

        //überprüfung, ob Fenster schon erstellt wurden, da sonst applet-remove eine Exception erzeugen würde, da noch keine Fenster offen sind;

        if (already_created) {

            Thread obj5 = new Thread(new hilfclassethread(5, objectpath));
            Thread obj6 = new Thread(new hilfclassethread(6, objectpath));
            Thread obj7 = new Thread(new hilfclassethread(7, objectpath));
            Thread obj8 = new Thread(new hilfclassethread(8, objectpath));
            obj5.start();
            obj6.start();
            obj7.start();
            obj8.start();
        }
        else {

            already_created = true;
            Thread obj1 = new Thread(new hilfclassethread(1, objectpath));
            Thread obj2 = new Thread(new hilfclassethread(2, objectpath));
            Thread obj3 = new Thread(new hilfclassethread(3, objectpath));
            Thread obj4 = new Thread(new hilfclassethread(4, objectpath));
            obj1.start();
            obj2.start();
            obj3.start();
            obj4.start();

        }
    }

        //Rotation;

    static void leftrotation() {

        Object.turnleft();
        Objectback.turnleft();
        Objectleft.turnleft();
        Objectright.turnleft();

    }

    static void rightrotation(){

        Object.turnright();
        Objectback.turnright();
        Objectleft.turnright();
        Objectright.turnright();

    }

}
