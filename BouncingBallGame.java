import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BouncingBallGame extends JPanel {
	
	int x = 20;
	int y = 30;
	int diameter = 30;
	int dx = 1;
	Ball ball = new Ball(this);
	Block block = new Block(this);
	
	public BouncingBallGame(){
		addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
				block.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
				block.keyReleased(e);
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
			Thread.sleep(2);
		}
	}
	
	public void move(){
		ball.move();
		block.move();;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.paint(g2d);
		block.paint(g2d);
	}
	
	public boolean detectCollision(){
		return block.getRectangle().intersects(ball.getRectangle());
	}
	
	public void gameOver(){
		Object options[] = {"Try Agin", "Exit"};
		int response = JOptionPane.showOptionDialog(this, "TRY AGAIN?", "GAME OVER", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		if (response == 0){
			ball.x = 0;
			ball.y = 0;
			block.x = 400;
		}
		else {
			System.exit(ABORT);
		}
	}
}
