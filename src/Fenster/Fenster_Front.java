package Fenster;

import javax.swing.*;


public class Fenster_Front {
	
	public static void main(String[] args) {
		
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
