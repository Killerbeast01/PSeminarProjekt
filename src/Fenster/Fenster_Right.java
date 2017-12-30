package Fenster;

import javax.swing.*;


public class Fenster_Right {

	public static void main(String[] args) {
		
	JFrame windowcontroller = new JFrame();
	
	windowcontroller.setTitle("Right");
	JPanel controllerpanel = new JPanel();
	
	JButton ok_button = new JButton("RightPerspective");
	
	controllerpanel.add(ok_button);
	
	windowcontroller.add(controllerpanel);
	
	windowcontroller.pack();
	
	windowcontroller.setVisible(true);
	
	
	}
	
}
