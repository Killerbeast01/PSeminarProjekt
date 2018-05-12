public class hilfclassethread extends Thread{
    public hilfclassethread(int i, String objectpath) {
        // 1 = object front load
        // 2 = object back load
        // 3 = object left load
        // 4 = object right load
        // 5 = object front change
        // 6 = object back change
        // 7 = object left change
        // 8 = object right change

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
}
