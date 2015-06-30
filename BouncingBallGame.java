import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BouncingBallGame extends JPanel {
	Ball ball = new Ball(this);
	Spring spring = new Spring(this);
	GamePanel north = new GamePanel(5,4);
	
	public BouncingBallGame(){
		addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				spring.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				spring.keyReleased(e);
			}
		});
		setFocusable(true);
	}
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		BouncingBallGame bouncing = new BouncingBallGame();
		
		frame.setPreferredSize(new Dimension(600,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bouncing Ball");
		bouncing.setBackground(Color.black);
		frame.add(bouncing);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		while(true){
			bouncing.move();
			bouncing.repaint();
			Thread.sleep(3);
		}
	}
	
	public void move(){
		ball.move();
		spring.move();;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.paint(g2d);
		spring.paint(g2d);
		north.paint(g2d);
	}
	
	public boolean detectCollision(){
		return (spring.getRectangle().intersects(ball.getRectangle()) || ball.getRectangle().intersects(spring.getRectangle()));
	}
	public int detectHit(){
		for (int i = 0; i < north.blocks.size(); i++){
			if ( north.blocks.get(i).intersects(ball.getRectangle()) || ball.getRectangle().intersects(north.blocks.get(i))){
				return i;
			}
		}
		return -1;
	}
	
	public void gameOver(){
		Object options[] = {"Try Agin", "Exit"};
		int response = JOptionPane.showOptionDialog(this, "TRY AGAIN?", "GAME OVER", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		if (response == 0){
			ball.x = 0;
			ball.y = 130;
			spring.x = 400;
			north.getBlocks();
		}
		else {
			System.exit(ABORT);
		}
	}
}

