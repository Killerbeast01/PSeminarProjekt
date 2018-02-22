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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Ladybird extends Applet implements KeyListener {

    private SimpleUniverse universe = null;
    private Canvas3D canvas = null;
    private TransformGroup viewtrans = null;
    private TransformGroup tg = null;
    private Transform3D t3d = null;
    private Transform3D t3dstep = new Transform3D();
    private Matrix4d matrix = new Matrix4d();

    public static void loadladybird() {
        System.out.println("load applet");
        Ladybird applet = new Ladybird();
        System.out.println("loaded applet");
        Frame frame = new MainFrame(applet, 800, 600);
        System.out.println("load frame");
        frame.setVisible(true);
        System.out.println("loaded applet");
    }


    public Ladybird() {
        System.out.println("load ladybird");
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        canvas = new Canvas3D(config);
        add("Center", canvas);
        universe = new SimpleUniverse(canvas);
        System.out.println("create ScenceGraph");
        BranchGroup scene = createSceneGraph();
        System.out.println("createdSenceGraph");
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.getViewer().getView().setBackClipDistance(100.0);
        canvas.addKeyListener(this);

        universe.addBranchGraph(scene);
        System.out.println("loaded ladybird");
    }

    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        BoundingSphere bounds = new BoundingSphere(new Point3d(), 10000.0);

        viewtrans = universe.getViewingPlatform().getViewPlatformTransform();

        KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(viewtrans);
        keyNavBeh.setSchedulingBounds(bounds);
        PlatformGeometry platformGeom = new PlatformGeometry();
        platformGeom.addChild(keyNavBeh);
        universe.getViewingPlatform().setPlatformGeometry(platformGeom);
        System.out.println("create ladybird");
        objRoot.addChild(createLadybird());
        System.out.println("created ladybird");

        Background background = new Background();
        background.setColor(0.75f, 0.69f, 0.680f);
        background.setApplicationBounds(bounds);
        objRoot.addChild(background);

        return objRoot;
    }

    private BranchGroup createLadybird() {

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

        File file = new java.io.File("model/ladybird2_w.obj");

        try {
            s = loader.load(file.toURI().toURL());
        } catch (Exception e) {
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



    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();

        if (key == 'd') {
            t3dstep.set(new Vector3d(0.0, 0.0, -0.1));
            tg.getTransform(t3d);
            t3d.mul(t3dstep);
            tg.setTransform(t3d);
        }

        if (key == 's') {

            t3dstep.rotY(Math.PI / 32);
            tg.getTransform(t3d);
            t3d.get(matrix);
            t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d.mul(t3dstep);
            t3d.setTranslation(new Vector3d(matrix.m03, matrix.m13, matrix.m23));
            tg.setTransform(t3d);

        }

        if (key == 'f') {

            t3dstep.rotY(-Math.PI / 32);
            tg.getTransform(t3d);
            t3d.get(matrix);
            t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d.mul(t3dstep);
            t3d.setTranslation(new Vector3d(matrix.m03, matrix.m13, matrix.m23));
            tg.setTransform(t3d);

        }

        if (key == 'r') {

            t3dstep.rotX(Math.PI / 32);
            tg.getTransform(t3d);
            t3d.get(matrix);
            t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d.mul(t3dstep);
            t3d.setTranslation(new Vector3d(matrix.m03, matrix.m13, matrix.m23));
            tg.setTransform(t3d);

        }

        if (key == 'v') {

            t3dstep.rotX(-Math.PI / 32);
            tg.getTransform(t3d);
            t3d.get(matrix);
            t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
            t3d.mul(t3dstep);
            t3d.setTranslation(new Vector3d(matrix.m03, matrix.m13, matrix.m23));
            tg.setTransform(t3d);

        }

        if (key == 'e') {
            t3dstep.set(new Vector3d(0.0, 0.1, 0.0));
            tg.getTransform(t3d);
            t3d.mul(t3dstep);
            tg.setTransform(t3d);
        }

        if (key == 'c') {
            t3dstep.set(new Vector3d(0.0, -0.1, 0.0));
            tg.getTransform(t3d);
            t3d.mul(t3dstep);
            tg.setTransform(t3d);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }
}