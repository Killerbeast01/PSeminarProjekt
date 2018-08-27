import javax.swing.*;

public class Controller extends JFrame {

    private JPanel rootpanel;
    private JButton btnaltesschulgebaeude;
    private JButton btnottohahn;
    private JButton btnneuesschulgebaeude;
    private JButton btnrotateleft;
    private JButton btnrotateright;
    private JButton btnrotationreset;

    public Controller() {

        super("Controller");
        setContentPane(rootpanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnaltesschulgebaeude.addActionListener(actionEvent -> Main.showoldschool());
        btnneuesschulgebaeude.addActionListener(actionEvent -> Main.showrecentschool());
        btnottohahn.addActionListener(actionEvent -> Main.showottohahn());
        btnrotateleft.addActionListener(actionEvent -> Main.rotateleft());
        btnrotateright.addActionListener(actionEvent -> Main.rotateright());
        btnrotationreset.addActionListener(actionEvent -> Main.rotatereset());

        setVisible(true);

        Main.startup();

    } //Erzeugt das Bedienfeld des Hologramms

}

