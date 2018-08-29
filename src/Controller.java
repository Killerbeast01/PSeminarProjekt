import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Controller{

    @FXML
    Button btn_old_school, btn_recent_school, btn_otto, btn_rotate_reset;

    @FXML
    Button btn_rotate_left, btn_rotate_right;

    @FXML
    void btn_old_school() {

        btn_old_school.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        btn_otto.setFont(null);
        btn_recent_school.setFont(null);
        Main.showoldschool();

    }

    @FXML
    void btn_recent_school() {

        btn_recent_school.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        btn_otto.setFont(null);
        btn_old_school.setFont(null);
        Main.showrecentschool();

    }

    @FXML
    void btn_otto() {

        btn_otto.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        btn_old_school.setFont(null);
        btn_recent_school.setFont(null);
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