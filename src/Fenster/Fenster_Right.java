package Fenster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Fenster_Right {
	
	private static int winkel;

	public Fenster_Right() {
		
		winkel = Main.Controller.rotation + 90;
			
		System.out.println("Rightfenster: läd");
		JFrame window_right = new JFrame();
		
		window_right.setTitle("Right");
		JPanel window_right_panel = new JPanel();
		
		JLabel rotation_label = new JLabel();
		rotation_label.setText(String.valueOf(winkel));
		
		window_right_panel.add(rotation_label);
		
		window_right.add(window_right_panel);
		
		window_right.pack();
		
		window_right.setVisible(true);
		
		System.out.println("Rightfenster: geladen");
		System.out.println("Objekt: läd");
		Fenster_Right.build_Object();
		while (Fenster.Fenster_Left.go == 1) {
			rotation_label.setText(String.valueOf(winkel));;
		}

		
	}
	
	public static void update() {
		winkel = Main.Controller.rotation + 90;
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
			winkel = Main.Controller.rotation + 90;
			System.out.println(winkel);
		}
	}
	
}
