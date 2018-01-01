package Main;
import javax.swing.*;


public class Controller {
	
protected int rotation = 0;
	
	public Controller() {	
			
		JFrame windowcontroller = new JFrame();
		
		windowcontroller.setTitle("Controller");
		JPanel controllerpanel = new JPanel();
		
		JButton rotate_left_button = new JButton("Rotate_Left"); //RotationsVariable verringern
		controllerpanel.add(rotate_left_button);
		rotate_left_button.setActionCommand("rotation - 5");
	
		
		JButton rotate_right_button = new JButton("Rotate_Right"); //RotationsVariable erhöhen 
		controllerpanel.add(rotate_right_button);
		rotate_right_button.setActionCommand("rotation + 5");
		
		
		JButton switch_oldSchool = new JButton("Altes Schulgebäude"); //Altes Schulgebäude anzeigen
		controllerpanel.add(switch_oldSchool);
		
		
		
		JButton switch_nowSchool = new JButton("Aktuelles Schulgebäude"); //Aktuelles Schulgebäude anzeigen
		controllerpanel.add(switch_nowSchool);
		
		
		
		JButton switch_OttoHahn = new JButton("Otto Hahn"); //Büste von Otto Hahn anzeigen
		controllerpanel.add(switch_OttoHahn);
				
		JButton get_Rotation = new JButton("Rotation"); //Zum Testen, ob die Buttons Rotate funktionieren
		controllerpanel.add(get_Rotation);
		rotate_right_button.setActionCommand("get_Rotation()");
		
		windowcontroller.add(controllerpanel);
		
		windowcontroller.pack();
		
		windowcontroller.setVisible(true);
		
		}

		
		public void get_Rotation() {
			
			println(rotation);
			
			
		}
		
		
}

