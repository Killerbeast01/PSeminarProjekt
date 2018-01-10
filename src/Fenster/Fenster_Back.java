package Fenster;


//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;



public class Fenster_Back {
	private static int winkel;

	public Fenster_Back()  {
		
		winkel = Main.Controller.rotation + 180;
		System.out.println("Backfenster: läd");
			
		JFrame window_back = new JFrame();
		
		window_back.setTitle("Back");
		JPanel window_back_panel = new JPanel();
		
		JLabel rotation_label = new JLabel();
		rotation_label.setText(String.valueOf(winkel));
		window_back_panel.add(rotation_label);
		
		window_back.add(window_back_panel);
		
		window_back.pack();
		
		window_back.setVisible(true);
		
		System.out.println("Backfenster: geladen");
		System.out.println("Objekt: läd");
		Fenster_Back.build_Object();
		SwingUtilities.updateComponentTreeUI(window_back);
		while (Fenster.Fenster_Left.go == 1) {
			rotation_label.setText(String.valueOf(winkel));;
			
		}
	}
	
	
	public static void update() {
		winkel = Main.Controller.rotation + 180;
	
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
	
