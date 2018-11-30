
import java.util.concurrent.TimeUnit;

public class turnThread extends Thread {

    private static int t=0;

    static void setT(int t) {
        turnThread.t = t;
    }

    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){

            if (t<5){

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t++;
            }
            else {
                Main.rotate();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }


}