package Fenster;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Fenster_Back {
	private static int winkel;

	public Fenster_Back()  {
		
		winkel = Main.Controller.rotation + 180;
		System.out.println("Backfenster: läd");
			
		JFrame window_back = new JFrame();
		
		window_back.setTitle("Back");
		JPanel window_back_panel = new JPanel();
		
		JButton ok_button = new JButton("BackPerspective");
		ButtonListener_get_winkel get_winkel = new ButtonListener_get_winkel();
		ok_button.addActionListener(get_winkel);
		
		window_back_panel.add(ok_button);
		
		window_back.add(window_back_panel);
		
		window_back.pack();
		
		window_back.setVisible(true);
		
		System.out.println("Backfenster: geladen");
		System.out.println("Objekt: läd");
		Fenster_Back.build_Object();
		
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
			winkel = Main.Controller.rotation + 180;
			System.out.println(winkel);
		}
	}
	
}
	
