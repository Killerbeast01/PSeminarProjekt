import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.ComboBox;

public class Controller {

    @FXML
    Button btn_rotate_reset;

    @FXML
    Button btn_rotate_left, btn_rotate_right;

    @FXML
    AnchorPane root;

    @FXML
    ChoiceBox cbModelChecker;

    @FXML
    ImageView arrowleft, arrowright;

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

    @FXML
    void cbModelChecker() {
        Main.modelchange();
    }

    public ChoiceBox getCbModelChecker() {
        return cbModelChecker;
    }

    public void setCbModelChecker(ChoiceBox cbModelChecker) {
        this.cbModelChecker = cbModelChecker;
    }
}