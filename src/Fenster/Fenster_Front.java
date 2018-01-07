package Fenster;

import java.awt.event.*;
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
		
		JButton ok_button = new JButton("FrontPerspective");
		ButtonListener_get_winkel get_winkel = new ButtonListener_get_winkel();
		ok_button.addActionListener(get_winkel);
		
		window_front_panel.add(ok_button);
		
		window_front.add(window_front_panel);
		
		window_front.pack();
		
		window_front.setVisible(true);
		
		System.out.println("Frontfenster: geladen");
		System.out.println("Objekt: läd");
		Fenster_Front.build_Object();
			
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
			winkel = Main.Controller.rotation + 0;
			System.out.println(winkel);
		}
	}
}
