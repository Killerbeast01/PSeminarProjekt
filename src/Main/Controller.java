package Main;
import javax.swing.*;
import java.awt.event.*;

public class Controller {
	
public static int rotation = 0;
	
	public Controller() {	
		
		System.out.println("Controller wird aufgerufen");
			
		JFrame window_controller = new JFrame();
		
		window_controller.setTitle("Controller");
		JPanel controller_panel = new JPanel();
		
		JButton rotate_left_button = new JButton("Rotate_Left"); //RotationsVariable verringern
		controller_panel.add(rotate_left_button);
		ButtonListener_rotate_left rotate_left = new ButtonListener_rotate_left();
		rotate_left_button.addActionListener(rotate_left);
	
		
		JButton rotate_right_button = new JButton("Rotate_Right"); //RotationsVariable erhöhen 
		controller_panel.add(rotate_right_button);
		rotate_right_button.setActionCommand("rotation_higher()");	
		ButtonListener_rotate_right rotate_right = new ButtonListener_rotate_right();
		rotate_right_button.addActionListener(rotate_right);
		
		
		
		JButton switch_oldSchool = new JButton("Altes Schulgebäude"); //Altes Schulgebäude anzeigen
		controller_panel.add(switch_oldSchool);
		
		
		
		JButton switch_nowSchool = new JButton("Aktuelles Schulgebäude"); //Aktuelles Schulgebäude anzeigen
		controller_panel.add(switch_nowSchool);
		
		
		
		JButton switch_OttoHahn = new JButton("Otto Hahn"); //Büste von Otto Hahn anzeigen
		controller_panel.add(switch_OttoHahn);
				
		JButton get_Rotation_button = new JButton("Rotation"); //Zum Testen, ob die Buttons Rotate funktionieren
		controller_panel.add(get_Rotation_button);
		ButtonListener_get_rotation get_rotation = new ButtonListener_get_rotation();
		get_Rotation_button.addActionListener(get_rotation);
		
		window_controller.add(controller_panel);
		
		window_controller.pack();
		
		window_controller.setVisible(true);
		
		}

		
		public void get_Rotation() {
			
			System.out.print(rotation);
						
		}
		
		public void rotation_higher() {
			rotation = rotation + 1;
		}
		
		
		class ButtonListener_rotate_right implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				rotation += 1;
			}
		}
		
		class ButtonListener_rotate_left implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				rotation -= 1;
			}
		}
		
		class ButtonListener_get_rotation implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println(rotation);
			}
		}
		
}

