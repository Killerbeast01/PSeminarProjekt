import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Controller{

    @FXML
    Button btn_old_school, btn_recent_school, btn_otto, btn_rotate_reset;

    @FXML
    Button btn_rotate_left, btn_rotate_right;

    @FXML
    AnchorPane root;

    @FXML
    void btn_old_school() {

        Main.showoldschool();

    }

    @FXML
    void btn_recent_school() {

        Main.showrecentschool();

    }

    @FXML
    void btn_otto() {

        Main.showottohahn();

    }

    @FXML
    void btn_rotate_reset() {

        Main.rotatereset();

    }

    @FXML
    void btn_rotate_right() {

        Main.rotateright();

    }

    @FXML
    void btn_rotate_left() {

        Main.rotateleft();

    }

}