import javax.swing.*;


public class Controller {
	
	public static void main(String[] args) {
		
		
	JFrame windowcontroller = new JFrame();
	
	windowcontroller.setTitle("Controller");
	JPanel controllerpanel = new JPanel();
	
	JButton ok_button = new JButton("OK");
	
	controllerpanel.add(ok_button);
	
	windowcontroller.add(controllerpanel);
	
	windowcontroller.pack();
	
	windowcontroller.setVisible(true);
	
		
	}
}