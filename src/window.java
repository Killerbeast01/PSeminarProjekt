import com.sun.j3d.utils.universe.SimpleUniverse;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Matrix4d;

class window {
    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;
    private TransformGroup viewtrans = null;
    private static TransformGroup tg = null;
    private static Transform3D t3d = null;
    private static Transform3D t3dstep = new Transform3D();
    private static Matrix4d matrix = new Matrix4d();
    private String window_id;
    private int mainrotaion;
    private String objectpath;

    window(String shownObject) {


        create_window(shownObject);
    }


    private void create_window(String object) {


        switch (object) {
            case "old_school":
                objectpath = "model/old_school/ladybird2_w.obj";
                break;
            case "recent_school":
                objectpath = "model/recent_school/recent_school_w.obj";
                break;
            case "otto_hahn":
                objectpath = "model/otto_hahn/otto_hahn_w.obj";
                break;
        }

        Object.loadObject(objectpath, mainrotaion, window_id);
        Objectback.loadObject(objectpath, mainrotaion, window_id);
        Objectleft.loadObject(objectpath, mainrotaion, window_id);
        Objectright.loadObject(objectpath, mainrotaion, window_id);
    }



    static void leftrotation() {
        Object.turnleft();
        Objectback.turnleft();
        Objectleft.turnleft();
        Objectright.turnleft();

    }

    static void rightrotation(){
        Object.turnright();
        Objectback.turnright();
        Objectleft.turnright();
        Objectright.turnright();
    }
    
}
