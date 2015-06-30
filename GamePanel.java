import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class GamePanel {
	int row;
	int column;
	final int WIDTH;
	final int HEIGHT;
	ArrayList <Rectangle> blocks = new ArrayList<>();
	public GamePanel(int row, int column){
		this.row = row;
		this.column = column;
		WIDTH = (int)(600-1)/column;
		HEIGHT = (int)(100-1)/row;
		getBlocks();
	}
	//@Override
	public void paint(Graphics g){
		for (int i = 0; i < blocks.size(); i++){
			g.setColor(Color.red);
			g.drawRect(blocks.get(i).x,blocks.get(i).y,blocks.get(i).width,blocks.get(i).height);
		}
		
	}
	public void getBlocks(){
		int x = 0;
		int y = 0;
		for (int i = 0; i < row; i++){
			for (int a = 0; a < column; a++){
				Rectangle rect = new Rectangle(x,y,WIDTH,HEIGHT);
				blocks.add(rect);
				x = x +  WIDTH;
			}
			x = 0;
			y = y + HEIGHT;
		}
	}
	public void removeBlock(int index){
		blocks.remove(index);
	}
}
