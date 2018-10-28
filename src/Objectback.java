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
public class Objectback extends JApplet {

    private SimpleUniverse universe, universerecent, universeotto;
    private static TransformGroup tg = null, tgrecent = null, tgotto = null;
    private static Transform3D t3d = null, t3drecent = null, t3dotto = null;
    private static Transform3D t3dstep = new Transform3D(), t3dsteprecent = new Transform3D(), t3dstepotto = new Transform3D();
    private static Matrix4d matrix = new Matrix4d(), matrixrecent = new Matrix4d(), matrixotto = new Matrix4d();
    static Frame frame;
    static Objectback applet_old;
    static Objectback applet_recent;
    static Objectback applet_otto;

    static void loadObject() {

        applet_old = new Objectback(1,Main.old_school_path);
        applet_old.setName("old");
        applet_recent = new Objectback(2, Main.recent_school_path);
        applet_recent.setName("recent");
        applet_otto = new Objectback(3, Main.otto_hahn_path);
        applet_otto.setName("otto");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new MainFrame(applet_old, screenSize.width / 2, screenSize.height / 2);
        frame.setLocation(screenSize.width / 2,0);
        frame.setBackground(Color.GRAY);
        frame.setSize(screenSize.width / 2, screenSize.height / 2);
        frame.setVisible(true);
        frame.setTitle("back");

    }

    private Objectback(int i ,String objectpath) {

        switch (i) {
            case (1):

                setLayout(new BorderLayout());
                GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

                Canvas3D canvas = new Canvas3D(config);
                add("Center", canvas);

                universe = new SimpleUniverse(canvas);

                BranchGroup scene = createSceneGraph(objectpath);

                universe.getViewingPlatform().setNominalViewingTransform();
                universe.getViewer().getView().setBackClipDistance(100.0);
                universe.addBranchGraph(scene);

                break;

            case (2):

                setLayout(new BorderLayout());
                GraphicsConfiguration configrecent = SimpleUniverse.getPreferredConfiguration();

                Canvas3D canvasrecent = new Canvas3D(configrecent);
                add("Center", canvasrecent);

                universerecent = new SimpleUniverse(canvasrecent);

                BranchGroup scenerecent = createSceneGraphrecent(objectpath);

                universerecent.getViewingPlatform().setNominalViewingTransform();
                universerecent.getViewer().getView().setBackClipDistance(100.0);
                universerecent.addBranchGraph(scenerecent);

                break;

            case (3):

                setLayout(new BorderLayout());
                GraphicsConfiguration configotto = SimpleUniverse.getPreferredConfiguration();

                Canvas3D canvasotto = new Canvas3D(configotto);
                add("Center", canvasotto);

                universeotto = new SimpleUniverse(canvasotto);

                BranchGroup sceneotto = createSceneGraphotto(objectpath);

                universeotto.getViewingPlatform().setNominalViewingTransform();
                universeotto.getViewer().getView().setBackClipDistance(100.0);
                universeotto.addBranchGraph(sceneotto);
                break;

        }

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

        objRoot.addChild(createObject(objectpath));

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

    //-------------------------------------------------------

    private BranchGroup createSceneGraphrecent(String objectpath) {

        BranchGroup objRoot = new BranchGroup();

        BoundingSphere bounds = new BoundingSphere(new Point3d(), 10000.0);

        TransformGroup viewtrans = universerecent.getViewingPlatform().getViewPlatformTransform();

        KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(viewtrans);
        keyNavBeh.setSchedulingBounds(bounds);

        PlatformGeometry platformGeom = new PlatformGeometry();
        platformGeom.addChild(keyNavBeh);

        universerecent.getViewingPlatform().setPlatformGeometry(platformGeom);

        objRoot.addChild(createObjectrecent(objectpath));

        Background background = new Background();
        background.setColor(0.5f, 0.5f, 0.5f);
        background.setApplicationBounds(bounds);
        objRoot.addChild(background);

        return objRoot;

    }

    private BranchGroup createObjectrecent(String objectpath) {

        BranchGroup objRoot = new BranchGroup();
        tgrecent = new TransformGroup();
        t3drecent = new Transform3D();

        tgrecent.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        t3drecent.setTranslation(new Vector3d(-0.15, -0.3, -5.0));
        t3drecent.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.0f));
        t3drecent.setScale(1.0);

        tgrecent.setTransform(t3drecent);

        ObjectFile loader = new ObjectFile(ObjectFile.RESIZE);
        Scene s = null;
        File file = new File(objectpath);

        try {
            s = loader.load(file.toURI().toURL());
        } catch (Exception e) {
            //noinspection ThrowablePrintedToSystemOut
            System.err.println(e);
            System.exit(1);
        }

        tgrecent.addChild(s.getSceneGroup());

        objRoot.addChild(tgrecent);
        objRoot.addChild(createLightrecent());

        objRoot.compile();

        return objRoot;

    }

    private Light createLightrecent() {

        DirectionalLight light = new DirectionalLight(true, new Color3f(1.0f,
                1.0f, 1.0f), new Vector3f(-0.3f, 0.2f, -1.0f));

        light.setInfluencingBounds(new BoundingSphere(new Point3d(), 10000.0));

        return light;

    }

    //--------------------------------------------------------

    private BranchGroup createSceneGraphotto(String objectpath) {

        BranchGroup objRoot = new BranchGroup();

        BoundingSphere bounds = new BoundingSphere(new Point3d(), 10000.0);

        TransformGroup viewtrans = universeotto.getViewingPlatform().getViewPlatformTransform();

        KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(viewtrans);
        keyNavBeh.setSchedulingBounds(bounds);

        PlatformGeometry platformGeom = new PlatformGeometry();
        platformGeom.addChild(keyNavBeh);

        universeotto.getViewingPlatform().setPlatformGeometry(platformGeom);
        objRoot.addChild(createObjectotto(objectpath));

        Background background = new Background();
        background.setColor(0.5f, 0.5f, 0.5f);
        background.setApplicationBounds(bounds);
        objRoot.addChild(background);

        return objRoot;

    }

    private BranchGroup createObjectotto(String objectpath) {

        BranchGroup objRoot = new BranchGroup();
        tgotto = new TransformGroup();
        t3dotto = new Transform3D();

        tgotto.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        t3dotto.setTranslation(new Vector3d(-0.15, -0.3, -5.0));
        t3dotto.setRotation(new AxisAngle4f(0.0f, 0.0f, 0.0f, 0.0f));
        t3dotto.setScale(1.0);

        tgotto.setTransform(t3dotto);

        ObjectFile loader = new ObjectFile(ObjectFile.RESIZE);
        Scene s = null;
        File file = new File(objectpath);

        try {
            s = loader.load(file.toURI().toURL());
        } catch (Exception e) {
            //noinspection ThrowablePrintedToSystemOut
            System.err.println(e);
            System.exit(1);
        }

        tgotto.addChild(s.getSceneGroup());

        objRoot.addChild(tgotto);
        objRoot.addChild(createLightotto());

        objRoot.compile();

        return objRoot;

    }

    private Light createLightotto() {

        DirectionalLight light = new DirectionalLight(true, new Color3f(1.0f,
                1.0f, 1.0f), new Vector3f(-0.3f, 0.2f, -1.0f));

        light.setInfluencingBounds(new BoundingSphere(new Point3d(), 10000.0));

        return light;

    }

    //---------------------------------------------------------

    public static void turnright() {

        t3dstep.rotY(-0.313);
        tg.getTransform(t3d);
        t3d.get(matrix);
        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3d.mul(t3dstep);
        t3d.setTranslation(new Vector3d(matrix.m03, matrix.m13, matrix.m23));
        tg.setTransform(t3d);

        t3dsteprecent.rotY(-0.313);
        tgrecent.getTransform(t3drecent);
        t3drecent.get(matrixrecent);
        t3drecent.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3drecent.mul(t3dsteprecent);
        t3drecent.setTranslation(new Vector3d(matrixrecent.m03, matrixrecent.m13, matrixrecent.m23));
        tgrecent.setTransform(t3drecent);

        t3dstepotto.rotY(-0.313);
        tgotto.getTransform(t3dotto);
        t3dotto.get(matrixotto);
        t3dotto.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3dotto.mul(t3dstepotto);
        t3dotto.setTranslation(new Vector3d(matrixotto.m03, matrixotto.m13, matrixotto.m23));
        tgotto.setTransform(t3dotto);

    }

    public static void turnleft() {

        t3dstep.rotY(0.313);
        tg.getTransform(t3d);
        t3d.get(matrix);
        t3d.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3d.mul(t3dstep);
        t3d.setTranslation(new Vector3d(matrix.m03, matrix.m13, matrix.m23));
        tg.setTransform(t3d);

        t3dsteprecent.rotY(0.313);
        tgrecent.getTransform(t3drecent);
        t3drecent.get(matrixrecent);
        t3drecent.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3drecent.mul(t3dsteprecent);
        t3drecent.setTranslation(new Vector3d(matrixrecent.m03, matrixrecent.m13, matrixrecent.m23));
        tgrecent.setTransform(t3drecent);

        t3dstepotto.rotY(0.313);
        tgotto.getTransform(t3dotto);
        t3dotto.get(matrixotto);
        t3dotto.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        t3dotto.mul(t3dstepotto);
        t3dotto.setTranslation(new Vector3d(matrixotto.m03, matrixotto.m13, matrixotto.m23));
        tgotto.setTransform(t3dotto);

    }
}