package p1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel
{
	private Ball ball;
	private Racquet1 racquet1;
	private Racquet2 racquet2;
	protected int speed = 1;	//will control the speed of the game
	public Game()
	{
		Color color = new Color(177, 201, 169);
		setBackground(color);
		racquet1 = new Racquet1(this);
		racquet2 = new Racquet2(this);
		ball = new Ball(this, racquet1, racquet2);
		this.addKeyListener(racquet1);
		this.addKeyListener(racquet2);
		this.setFocusable(true);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g ;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Graphics2d uses advanced graphics tools like in this case it is used to make the border of the ball smoother.
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, getWidth(), 4);
		g2d.fillRect(0, getHeight()-4, getWidth(), 4);
		ball.paint(g2d);
		racquet1.paint(g2d);
		racquet2.paint(g2d);
	}	
	
	private void move()
	{
		ball.move();
		racquet1.move();
		racquet2.move();
	}
	
	public void gameOver(int winner)
	{
		String msg = null;
		if(winner == 1)
			msg = "Player 1 wins.";
		else if(winner ==2)
			msg = "Player 2 wins.";
		JOptionPane.showMessageDialog(this, msg, "Game Over", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	
	
	//---------------------------Main method--------------------------
	public static void  main(String [] args) throws InterruptedException
	{
		JFrame frame = new JFrame("RacqueBall");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 350, 400);
		
		String str=
				"<html><big><font color='green'>RacquetBall</font></big><hr>"
				+"<p align=center><font size='5' color='blue'>Players</font>"
				+"<br><br><p align=left>Player1 - Yellow Racquet"
				+"<p align=left>Player2 - Pink Racquet"
				+"<hr><p align=center><font size='5' color='blue'>Controls</font>"
				+"<br><br><p align=left>Player1 - Keys- Left & Right"
				+"<p align=left>Player2 - Keys- A & D<hr>"
				+"<br><p align=center>Click 'OK' to start the game.<br>";
		
		int value =JOptionPane.showConfirmDialog(frame, str, "Game instructions", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(value== JOptionPane.CLOSED_OPTION)
			System.exit(0);
		Game game = new Game();
		frame.setContentPane(game);
		frame.setVisible(true);
		while(true)
		{
			game.move();
			game.repaint();
			Thread.sleep(16);
		}
	}
}
