package bouncing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;

public class game extends JApplet{
	MyPanel panel;
	public void init(){
		panel = new MyPanel();
		//panel.setBackground(Color.black);
		setSize(600,600);
		add(panel);
		
		Timer timer = new Timer(1, new MyTimerActionListener(panel));
		timer.start();
	}
}

class MyTimerActionListener implements ActionListener{
	MyPanel panel;
	MyTimerActionListener(MyPanel panel){
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("lalala");
		panel.repaint();
	}
	
}

