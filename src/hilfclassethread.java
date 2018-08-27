public class hilfclassethread implements Runnable{

    private int Fall;

    hilfclassethread(int i ) {

            Fall = i;

    }

    @Override
    public void run() {

        switch (Fall) {
            case 1: Object.loadObject();
                break;
            case 2: Objectback.loadObject();
                break;
            case 3: Objectleft.loadObject();
                break;
            case 4: Objectright.loadObject();
                break;
        }

    } //Erzeugt je nach übergebenem Fall ein Fenster in einem Thread

}
