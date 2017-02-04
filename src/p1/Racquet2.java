package p1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Racquet2 implements KeyListener {
	protected static int x ;
	private int y=23;		
	/*value of y has been initialized in paint but for some reasons its giving unexpected result if I don't initialize the 
	value of y here and also value of y must be greater than 22 in order to run the game successfully.(Don't know why)
	Running fine while debugging.*/
	
	protected final int WIDTH = 50;
	protected final int HEIGHT = 10;
	private static int vx = 0;
	Game game;
	private int flag = 0;		
	/*flag will serve the purpose to position the racquet for the first time paint in invoked
	as to position the racquet game.getWidth() is required which returns '0' inside constructor.*/
	
	public Racquet2(Game game)
	{
		this.game = game;
	}
	
	
	
	public void paint(Graphics2D g2d)
	{
		if(flag==0)
		{
			x= (game.getWidth()/2) - WIDTH/2 ;	   	//POSITIONING THE RACQUET AT THE CENTER
			y= game.getHeight()- 25;	
			flag = 1;
		}
		g2d.setColor(Color.magenta);
		g2d.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void move()
	{
		if(x+vx > 0 && x+vx < game.getWidth() - WIDTH)
			x+= vx;
	}
	
	public void keyReleased(KeyEvent e)
	{
		vx = 0;
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_A)
				vx = -game.speed;
		if(e.getKeyCode() == KeyEvent.VK_D)
				vx = game.speed;			
	}
	
	public int getTopY()
	{
		return y;
	}
	
}
