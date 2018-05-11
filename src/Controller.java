import javax.swing.*;

public class Controller extends JFrame {


    private JPanel rootpanel;
    private JButton btnaltesschulgebaude;
    private JButton btnottohahn;
    private JButton btnneuesschulgebäude;
    private JButton btnrotateleft;
    private JButton btnrotateright;
    private JButton btnrotationreset;

    public Controller() {
        super("Controller");
        setContentPane(rootpanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        btnaltesschulgebaude.addActionListener(actionEvent -> Main.showoldschool());
        btnneuesschulgebäude.addActionListener(actionEvent -> Main.showrecentschool());
        btnottohahn.addActionListener(actionEvent -> Main.showottohahn());
        btnrotateleft.addActionListener(actionEvent -> Main.rotateleft());
        btnrotateright.addActionListener(actionEvent -> Main.rotateright());
        btnrotationreset.addActionListener(actionEvent -> Main.rotatereset());

        setVisible(true);

    }

}

