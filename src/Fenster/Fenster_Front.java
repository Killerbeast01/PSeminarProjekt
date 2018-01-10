package Fenster;

import javax.swing.*;


public class Fenster_Front /*extends Main.Controller */ {
	
	
	private static int winkel;
	
	public Fenster_Front() {
		
		System.out.println("Frontfenster: läd");
		winkel = Main.Controller.rotation + 0;
		
		//System.out.print(winkel);
			
		JFrame window_front = new JFrame();
		
		window_front.setTitle("Front");
		JPanel window_front_panel = new JPanel();
		
		JLabel rotation_label = new JLabel();
		
		rotation_label.setText(String.valueOf(winkel));
		
		window_front_panel.add(rotation_label);
		
		window_front.add(window_front_panel);
		
		window_front.pack();
		
		window_front.setVisible(true);
		
		System.out.println("Frontfenster: geladen");
		System.out.println("Objekt: läd");
		Fenster_Front.build_Object();
		while (Fenster.Fenster_Left.go == 1) {
			rotation_label.setText(String.valueOf(winkel));
		}

			
	}
	
	public static void update() {
		winkel = Main.Controller.rotation + 0;
	}
	
	public static void build_Object() {
		//Import von Objekt
		//Objektausrichtung mit
		System.out.print("Winkel des Objektes beträgt: ");
		System.out.println(winkel);
		//festlegen
		System.out.println("Objekt: geladen");
	}
	
}
