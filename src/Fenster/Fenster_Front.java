package Fenster;

import javax.swing.*;


public class Fenster_Front extends Main.Controller {
	
	private int winkel;
	
	public Fenster_Front() {
		
	winkel = rotation + 0;
	
	System.out.print(winkel);
		
	JFrame windowcontroller = new JFrame();
	
	windowcontroller.setTitle("Front");
	JPanel controllerpanel = new JPanel();
	
	JButton ok_button = new JButton("FrontPerspective");
	
	controllerpanel.add(ok_button);
	
	windowcontroller.add(controllerpanel);
	
	windowcontroller.pack();
	
	windowcontroller.setVisible(true);
	
	
	}	
}
