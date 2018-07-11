class window {

    private static String objectpath;
    private static boolean already_created = false;

    window(String shownObject) {}

    static void rightrotation() {

        Object.turnleft();
        Objectback.turnleft();
        Objectleft.turnleft();
        Objectright.turnleft();
        Objectnew.turnleft();
        Objectbacknew.turnleft();
        Objectleftnew.turnleft();
        Objectrightnew.turnleft(); }

    static void leftrotation(){

        Object.turnright();
        Objectback.turnright();
        Objectleft.turnright();
        Objectright.turnright();
        Objectnew.turnright();
        Objectbacknew.turnright();
        Objectleftnew.turnright();
        Objectrightnew.turnright();

    }

}
