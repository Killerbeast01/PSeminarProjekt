import java.awt.*;
import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.PlatformGeometry;
import com.sun.j3d.utils.behaviors.keyboard.*;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import java.io.*;
@SuppressWarnings("deprecation")
public class Objectright extends JApplet {

    static Frame frame;
    static Objectright[] applets;
    private static BranchGroup[] scene;
    private static TransformGroup[] tg;
    private static Transform3D[] t3d;
    private static Transform3D[] t3dstep;
    private static Matrix4d[] matrix;

    private static SimpleUniverse[] universe;

    static void loadObject() {

        universe = new SimpleUniverse[Main.ordnerarray.length];
        scene = new BranchGroup[Main.ordnerarray.length];
        tg = new TransformGroup[Main.ordnerarray.length];
        t3d = new Transform3D[Main.ordnerarray.length];
        t3dstep = new Transform3D[Main.ordnerarray.length];
        for (int z=0; z < t3dstep.length; z++) { t3dstep[z] = new Transform3D(); }
        matrix = new Matrix4d[Main.ordnerarray.length];
        for (int z=0; z < matrix.length; z++) { matrix[z] = new Matrix4d(); }


        Main.lg.info("Erzeuge Fenster;");
        Main.lg.info("Erzeuge applet_old;");

        applets = new Objectright[Main.ordnerarray.length];

        for (int i = 0; i < applets.length; i++) {

            applets[i] = new Objectright(i,Main.ordnerarray[i].getName());
            applets[i].setName(Main.ordnerarray[i].getName());

        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new MainFrame(applets[0], screenSize.width / 2, screenSize.height / 2);


        frame.setBackground(Color.GRAY);
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setTitle("rechts");
        Main.lg.info("Fenster erzeugt;");
        runturnright();
        setforward();
        Main.Fenster += 1;

    }

    private Objectright(int i ,String objectpath) {




        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

        Canvas3D canvas = new Canvas3D(config);
        add("Center", canvas);

        universe[i] = new SimpleUniverse(canvas);


        scene[i] = createSceneGraph(i, objectpath);


        universe[i].getViewingPlatform().setNominalViewingTransform();
        universe[i].getViewer().getView().setBackClipDistance(100.0);
        universe[i].addBranchGraph(scene[i]);



    }

    private BranchGroup createSceneGraph(int i,String objectpath) {

        BranchGroup objRoot = new BranchGroup();

        BoundingSphere bounds = new BoundingSphere(new Point3d(), 10000.0);

        TransformGroup viewtrans = universe[i].getViewingPlatform().getViewPlatformTransform();

        KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(viewtrans);
        keyNavBeh.setSchedulingBounds(bounds);

        PlatformGeometry platformGeom = new PlatformGeometry();
        platformGeom.addChild(keyNavBeh);

        universe[i].getViewingPlatform().setPlatformGeometry(platformGeom);
        objRoot.addChild(createObject(i, objectpath));

        Background background = new Background();
        background.setColor(1f, 1f, 1f);
        background.setApplicationBounds(bounds);
        objRoot.addChild(background);

        return objRoot;

    }

    private static void setforward(){

        for (int i = 0; i < applets.length; i++) {

            t3dstep[i].setScale(4);
            tg[i].getTransform(t3d[i]);
            t3d[i].get(matrix[i]);
            t3d[i].setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d[i].mul(t3dstep[i]);
            t3d[i].setTranslation(new Vector3d(matrix[i].m03, matrix[i].m13, matrix[i].m23));
            tg[i].setTransform(t3d[i]);
        }

    }

    private BranchGroup createObject(int i, String objectpath) {

        BranchGroup objRoot = new BranchGroup();
        tg[i] = new TransformGroup();
        t3d[i] = new Transform3D();

        tg[i].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        t3d[i].setTranslation(new Vector3d(-0.15, -0.3, -5.0));
        t3d[i].setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.0f));
        t3d[i].setScale(1.0);

        tg[i].setTransform(t3d[i]);

        ObjectFile loader = new ObjectFile(ObjectFile.RESIZE);
        Scene s = null;
        File file = new File("model/" + objectpath + "/" + objectpath +".obj");

        try {
            s = loader.load(file.toURI().toURL());
        } catch (Exception e) {
            //noinspection ThrowablePrintedToSystemOut
            System.err.println(e);
            System.exit(1);
        }

        tg[i].addChild(s.getSceneGroup());

        objRoot.addChild(tg[i]);
        objRoot.addChild(createLight());

        objRoot.compile();

        return objRoot;

    }

    private Light createLight() {

        DirectionalLight light = new DirectionalLight(true, new Color3f(1.0f,
                1.0f, 1.0f), new Vector3f(-0.3f, 0.2f, -1.0f));
        light.setInfluencingBounds(new BoundingSphere(new Point3d(), 10000.0));
        return light;

    }

    static void turnright() {

        for (int i = 0; i < Main.ordnerarray.length; i++) {

            t3dstep[i].rotY(-0.313);
            tg[i].getTransform(t3d[i]);
            t3d[i].get(matrix[i]);
            t3d[i].setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d[i].mul(t3dstep[i]);
            t3d[i].setTranslation(new Vector3d(matrix[i].m03, matrix[i].m13, matrix[i].m23));
            tg[i].setTransform(t3d[i]);

        }

    } //Dreht das angezeigte Objekt nach rechts

    static void turnleft() {

        for (int i = 0; i < Main.ordnerarray.length; i++) {

            t3dstep[i].rotY(0.313);
            tg[i].getTransform(t3d[i]);
            t3d[i].get(matrix[i]);
            t3d[i].setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d[i].mul(t3dstep[i]);
            t3d[i].setTranslation(new Vector3d(matrix[i].m03, matrix[i].m13, matrix[i].m23));
            tg[i].setTransform(t3d[i]);

        }


    } //Dreht das angezeigte Objekt nach links

    static void standbyrotate() {

        for (int i = 0; i < Main.ordnerarray.length; i++) {

            t3dstep[i].rotY(-0.01);
            tg[i].getTransform(t3d[i]);
            t3d[i].get(matrix[i]);
            t3d[i].setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d[i].mul(t3dstep[i]);
            t3d[i].setTranslation(new Vector3d(matrix[i].m03, matrix[i].m13, matrix[i].m23));
            tg[i].setTransform(t3d[i]);

        }

    }

    static void standbyrotatereverse() {

        for (int i = 0; i < Main.ordnerarray.length; i++) {

            t3dstep[i].rotY(0.01);
            tg[i].getTransform(t3d[i]);
            t3d[i].get(matrix[i]);
            t3d[i].setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d[i].mul(t3dstep[i]);
            t3d[i].setTranslation(new Vector3d(matrix[i].m03, matrix[i].m13, matrix[i].m23));
            tg[i].setTransform(t3d[i]);

        }

    }

    private static void runturnright() {

        for (int count = 0; count < 5; count++) {

            turnleft();

        }
    }
}