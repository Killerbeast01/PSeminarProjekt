package Fenster;

import javax.swing.*;


public class Fenster_Back {

	public Fenster_Back()  {
		
	JFrame windowcontroller = new JFrame();
	
	windowcontroller.setTitle("Back");
	JPanel controllerpanel = new JPanel();
	
	JButton ok_button = new JButton("BackPerspective");
	
	controllerpanel.add(ok_button);
	
	windowcontroller.add(controllerpanel);
	
	windowcontroller.pack();
	
	windowcontroller.setVisible(true);
	
	
	}
	
}
