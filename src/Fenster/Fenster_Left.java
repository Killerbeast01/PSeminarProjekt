package Fenster;

import javax.swing.*;


public class Fenster_Left {

	public static void main(String[] args) {
		
	JFrame windowcontroller = new JFrame();
	
	windowcontroller.setTitle("Left");
	JPanel controllerpanel = new JPanel();
	
	JButton ok_button = new JButton("LeftPerspective");
	
	controllerpanel.add(ok_button);
	
	windowcontroller.add(controllerpanel);
	
	windowcontroller.pack();
	
	windowcontroller.setVisible(true);
	
	
	}
	
}
