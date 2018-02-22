import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class window {

    private String window_id;
    private int mainrotaion;

    window(String new_window_id, String shownObject) {
        window_id = new_window_id;
        checkup();
        create_window(window_id, mainrotaion, shownObject);
    }

    private void checkup() {
        switch (window_id) {
            case ("front"):
                mainrotaion = 0;
                break;
            case ("right"):
                mainrotaion = 90;
                break;
            case ("back"):
                mainrotaion = 180;
                break;
            case ("left"):
                mainrotaion = 270;
                break;
        }
    }

    private void create_window(String window_id, int mainrotaion, String object) {
        System.out.print(mainrotaion);
        System.out.println(" " + object);
        Stage window = new Stage();
        window.setTitle(window_id);

        Pane pn = new Pane();
        pn.setTranslateX(1024);
        pn.setTranslateY(768);
        window.setScene(new Scene(pn, 1024, 768));
        loadobject(object);
        window.show();
    }

    private void loadobject(String object) {

    }
}
