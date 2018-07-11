public class go implements Runnable{

    private static int object;

    public go(int objectn) {
        object = objectn;
        System.out.println("info erhalten " + object);


    }


    @Override
    public void run() {
        //aufmachen der objecte
        System.out.println(object);
        switch (object) {
            case (1): Object.loadObject();
                System.out.println("start 1");
            break;
            case (2): Objectback.loadObject();
                break;
            case (3): Objectleft.loadObject();
                break;
            case (4): Objectright.loadObject();
                break;
            case (5): Objectnew.loadObject();
                break;
            case (6): Objectbacknew.loadObject();
                break;
            case (7): Objectleftnew.loadObject();
                break;
            case (8): Objectrightnew.loadObject();
                break;

        }
    }
}
