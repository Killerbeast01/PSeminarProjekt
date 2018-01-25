import javafx.stage.*;
import javafx.scene.*;


import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.transform.*;


import javafx.animation.*;
import javafx.util.*;


public class Hologramm {

    public Hologramm(int Rotation, String title) {
        Stage window = new Stage();
        window.setTitle(title);

        Pane pn = new Pane();
        pn.setTranslateX(512);
        pn.setTranslateY(384);

        Box bo = new Box(100,100,100);
        bo.setMaterial(new PhongMaterial((Color.LIGHTGREEN)));
        bo.getTransforms().add(new Rotate(Rotation, 0, 0, 0, Rotate.Y_AXIS ));
        pn.getChildren().add(bo);

        RotateTransition rt = new RotateTransition(Duration.seconds(3), bo);
        rt.setAxis(Rotate.Y_AXIS);
        rt.setCycleCount(2);
        rt.setToAngle(90);
        rt.play();

        window.setScene(new Scene(pn, 1024, 768));
        window.show();



    }





}
