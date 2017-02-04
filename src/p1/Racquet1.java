package p1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Racquet1 implements KeyListener {

	protected static int x ;
	protected int y = 15 ;
	protected final int WIDTH = 50;
	protected final int HEIGHT = 10;
	private static int vx = 0;
	Game game;
	private int flag = 0;		
	/*flag will serve the purpose to position the racquet for the first time paint in invoked
	as to position the racquet game.getWidth() is required which returns '0' inside constructor.*/
	
	public Racquet1(Game game)
	{
		this.game = game;
		//x= (game.getWidth()/2) - WIDTH/2 ;	   	//POSITIONING THE RACQUET AT THE CENTER
	}
	
	public void paint(Graphics2D g2d)
	{		 
		if(flag==0)
		{
			x= (game.getWidth()/2) - WIDTH/2 ;	   	//POSITIONING THE RACQUET AT THE CENTER
			flag = 1;
		}
		g2d.setColor(Color.yellow);
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
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
				vx = -game.speed;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				vx = game.speed;			
	}
	
	public int getBottomY()
	{
		return y+HEIGHT;
	}	
}
