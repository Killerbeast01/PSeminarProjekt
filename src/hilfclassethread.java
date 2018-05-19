public class hilfclassethread implements Runnable{

    private int Fall;
    private String path;

    public hilfclassethread(int i, String objectpath) {
            Fall = i;
            path = objectpath;

            switch (i) {
                case 1: Object.loadObject(objectpath);
                    break;
                case 2: Objectback.loadObject(objectpath);
                    break;
                case 3: Objectleft.loadObject(objectpath);
                    break;
                case 4: Objectright.loadObject(objectpath);
                    break;
                case 5: Object.objectchange(objectpath);
                    break;
                case 6: Objectback.objectchange(objectpath);
                    break;
                case 7: Objectleft.objectchange(objectpath);
                    break;
                case 8: Objectright.objectchange(objectpath);
                    break;
                    }


    }

    @Override
    public void run() {
        switch (Fall) {
            case 1: Object.loadObject(path);
                break;
            case 2: Objectback.loadObject(path);
                break;
            case 3: Objectleft.loadObject(path);
                break;
            case 4: Objectright.loadObject(path);
                break;
            case 5: Object.objectchange(path);
                break;
            case 6: Objectback.objectchange(path);
                break;
            case 7: Objectleft.objectchange(path);
                break;
            case 8: Objectright.objectchange(path);
                break;
        }


    }
}
