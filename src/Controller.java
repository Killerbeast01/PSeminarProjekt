import javax.swing.*;


public class Controller {
	
	public Controller() {	
			
		JFrame windowcontroller = new JFrame();
		
		windowcontroller.setTitle("Controller");
		JPanel controllerpanel = new JPanel();
		
		JButton rotate_left_button = new JButton("Rotate_Left");
		
		controllerpanel.add(rotate_left_button);
		
		JButton rotate_right_button = new JButton("Rotate_Right");
		
		controllerpanel.add(rotate_right_button);
		
		
		
		
		
		windowcontroller.add(controllerpanel);
		
		windowcontroller.pack();
		
		windowcontroller.setVisible(true);
		
		}
	
}