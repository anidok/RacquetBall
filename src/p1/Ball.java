package p1;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
	private static final int DIAMETER = 20;
	private static int x = 0;
	private static int y = 0;
	private static int vx = 1;
	private static int vy = 1;
	Racquet1 racquet1;
	Racquet2 racquet2;
	Game game;
	private int flag = 0;		
	/*flag will serve the purpose to position the ball for the first time paint in invoked
	as to position the, ball game.getWidth() is required which returns '0' inside constructor.*/
	
	public Ball(Game game, Racquet1 racquet1, Racquet2 racquet2)
	{
		this.game = game;
		this.racquet1 = racquet1;
		this.racquet2 = racquet2;
	}
	
	public void move()
	{
		if(x+vx > game.getWidth() - DIAMETER)
			vx = -game.speed;
		if(x+vx < 0)
			vx = game.speed;
		
		//-----------------------Game Over------------------------
		if(y+vy > game.getHeight() - DIAMETER)
			game.gameOver(1);		//passing 1 as player1 wins in this case.
		if(y+vy < 0)
			game.gameOver(2);		//passing 2 as player2 wins in this case.
		
		
		//-------------------Checking Collision detection----------------------------------
		if((y+DIAMETER+vy > racquet2.getTopY()) & ((x> racquet2.x & x< racquet2.x + Racquet.WIDTH) | (x+DIAMETER> racquet2.x & x+DIAMETER< racquet2.x + Racquet.WIDTH)) )
		{
			vy = -game.speed;
			System.out.println(game.speed);
		}
		if(y+vy < racquet1.getBottomY() & ((x> racquet1.x & x< racquet1.x + Racquet.WIDTH) | (x+DIAMETER> racquet1.x & x+DIAMETER< racquet1.x + Racquet.WIDTH)) )
		{
			vy = game.speed;
			game.speed++;  //each time ball hits the racquet1 increase the speed by 1.
			//System.out.println(game.speed);
		}
		
		x+= vx;
		y+= vy;
	}
	
	public void paint(Graphics2D g2d)
	{
		if(flag==0)
		{
			x= (game.getWidth()/2) - DIAMETER/2 ;	   	//POSITIONING THE BALL AT THE CENTER
			y= racquet1.y + Racquet.HEIGHT + 5;
			flag = 1;
		}
		g2d.setColor(Color.BLUE);
		g2d.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	
}
