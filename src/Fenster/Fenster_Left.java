package Fenster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Fenster_Left {
	
	protected static int go;

	private static int winkel;
	private static JLabel rotation_label;
	
	public Fenster_Left() {
		
		winkel = Main.Controller.rotation + 270; 
			
		System.out.println("Leftfenster: läd");	
			
		JFrame window_left = new JFrame();
		
		window_left.setTitle("Left");
		JPanel window_left_panel = new JPanel();
		
		rotation_label = new JLabel();
		rotation_label.setText(String.valueOf(winkel));
		
		window_left_panel.add(rotation_label);
		
		window_left.add(window_left_panel);
		
		window_left.pack();
		
		window_left.setVisible(true);
		System.out.println("Leftfenster: geladen");
		System.out.println("Objekt: läd");
		Fenster_Left.build_Object();
				
	}
	
	public static void update() {
		winkel = Main.Controller.rotation + 270;
		rotation_label.setText(String.valueOf(winkel));	
	}
	
	public static void build_Object() {
		//Import von Objekt
		//Objektausrichtung mit
		System.out.print("Winkel des Objektes beträgt: ");
		System.out.println(winkel);
		//festlegen
		System.out.println("Objekt: geladen");
	}
	
	class ButtonListener_get_winkel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			winkel = Main.Controller.rotation + 270;
			System.out.println(winkel);
		}
	}
	
}
	

