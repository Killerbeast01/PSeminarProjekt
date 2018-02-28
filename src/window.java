class window {
    private static String objectpath;
    private static boolean already_created = false;

    window(String shownObject) {


        create_window(shownObject);
    }


    private static void create_window(String object) {

        switch (object) {
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


        if (already_created) {
            Object.objectchange(objectpath);
            Objectright.objectchange(objectpath);
            Objectleft.objectchange(objectpath);
            Objectback.objectchange(objectpath);
        }
        else {
            already_created = true;
            Object.loadObject(objectpath);
            Objectright.loadObject(objectpath);
            Objectleft.loadObject(objectpath);
            Objectback.loadObject(objectpath);
        }
    }



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
