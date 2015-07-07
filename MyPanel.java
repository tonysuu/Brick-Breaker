package bouncing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	public MyPanel(){
		setBackground(Color.black);
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Random rand = new Random();
		float r = rand.nextFloat();
	    float green = rand.nextFloat();
	    float b = rand.nextFloat();
	    g.setColor(new Color(r, green, b));
	    g.drawRect(0,0,50,50);
	}
}