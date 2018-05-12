import java.applet.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.PlatformGeometry;
import com.sun.j3d.utils.behaviors.keyboard.*;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import java.io.*;

public class Object extends Applet {

    private SimpleUniverse universe;
    private static TransformGroup tg = null;
    private static Transform3D t3d = null;
    private static Transform3D t3dstep = new Transform3D();
    private static Matrix4d matrix = new Matrix4d();
    private static Frame frame;
    private static Object applet;

       public static void loadObject(String objectpath) {

        System.out.println("load applet for obj front");
        applet = new Object(objectpath);
        System.out.println("loaded applet for obj front");
        frame = new MainFrame(applet, 800, 600);
        System.out.println("load frame for obj front");
        frame.setVisible(true);
        frame.setTitle("front");
        System.out.println("loaded frame for obj front");
        runturnleft();

    }


    public static void objectchange(String objectpath) {

        frame.remove(applet);
        frame.validate();
        frame.update(frame.getGraphics());
        System.out.println("load applet again");
        applet = null;
        applet = new Object(objectpath);
        System.out.println("loaded applet");
        System.out.println("load frame");
        frame.add(applet);
        frame.validate();
        frame.update(frame.getGraphics());
        frame.setVisible(true);
        frame.setTitle("front");
        System.out.println("loaded applet for obj front again");
        runturnleft();


    }

    public Object(String objectpath) {

        System.out.println("load object");

        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

        Canvas3D canvas = new Canvas3D(config);
        add("Center", canvas);

        universe = new SimpleUniverse(canvas);

        System.out.println("create ScenceGraph");
        BranchGroup scene = createSceneGraph(objectpath);
        System.out.println("createdSenceGraph");

        universe.getViewingPlatform().setNominalViewingTransform();
        universe.getViewer().getView().setBackClipDistance(100.0);
        universe.addBranchGraph(scene);

        System.out.println("loaded object");

    }

    private BranchGroup createSceneGraph(String objectpath) {

        BranchGroup objRoot = new BranchGroup();

        BoundingSphere bounds = new BoundingSphere(new Point3d(), 10000.0);

        TransformGroup viewtrans = universe.getViewingPlatform().getViewPlatformTransform();

        KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(viewtrans);
        keyNavBeh.setSchedulingBounds(bounds);

        PlatformGeometry platformGeom = new PlatformGeometry();
        platformGeom.addChild(keyNavBeh);

        universe.getViewingPlatform().setPlatformGeometry(platformGeom);

        System.out.println("create Object");
        objRoot.addChild(createObject(objectpath));
        System.out.println("created Object");

        Background background = new Background();
        background.setColor(0.5f, 0.5f, 0.5f);
        background.setApplicationBounds(bounds);
        objRoot.addChild(background);

        return objRoot;

    }

    private BranchGroup createObject(String objectpath) {

        BranchGroup objRoot = new BranchGroup();
        tg = new TransformGroup();
        t3d = new Transform3D();

        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        t3d.setTranslation(new Vector3d(-0.15, -0.3, -5.0));
        t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.0f));
        t3d.setScale(1.0);

        tg.setTransform(t3d);

        ObjectFile loader = new ObjectFile(ObjectFile.RESIZE);
        Scene s = null;
        System.out.print("used filepath:");
        System.out.println(objectpath);
        File file = new File(objectpath);

        try {
            s = loader.load(file.toURI().toURL());
        } catch (Exception e) {
            //noinspection ThrowablePrintedToSystemOut
            System.err.println(e);
            System.exit(1);
        }

        tg.addChild(s.getSceneGroup());

        objRoot.addChild(tg);
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

    public static void turnright() {

        t3dstep.rotY(-0.313);
        tg.getTransform(t3d);
        t3d.get(matrix);
        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3d.mul(t3dstep);
        t3d.setTranslation(new Vector3d(matrix.m03, matrix.m13, matrix.m23));
        tg.setTransform(t3d);

    }

    public static void turnleft() {

        t3dstep.rotY(0.313);
        tg.getTransform(t3d);
        t3d.get(matrix);
        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3d.mul(t3dstep);
        t3d.setTranslation(new Vector3d(matrix.m03, matrix.m13, matrix.m23));
        tg.setTransform(t3d);

    }

    private static void runturnleft() {

        for (int count = 0; count < 10; count++) {

            turnleft();

        }
    }
}