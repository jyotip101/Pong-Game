package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	double y, yVel;
	boolean upDir, downDir;
	int playear, x;
	final double GRAVITY = 0.49;
	
    public Paddle(int playear) {
    	upDir = false; downDir = false;
		y = 210; yVel = 0;
		//for left and right paddle to control
		if(playear == 1)
			x = 10;
	    else if(playear == 2)
	    	x = 660;
	}
	public void draw(Graphics g) {
		g.setColor(Color.yellow );
		//left paddle
		g.fillRect(x, (int)y, 20, 80);
	}

	public void setUpDir(boolean input) {
		upDir = input;
	}
	public void setDounDir(boolean input) {
		downDir = input;
	}

	public void move() {
		//for move the paddle
		if(upDir) {
			yVel -= 2;
		}else if(downDir) {
			yVel += 2;
		}else if(!upDir && !downDir) {
			yVel *= GRAVITY;
		}
		
		//for set slow speed of paddle
		if(yVel  >= 5)
			yVel = 5;
		else if(yVel <= -5)
			yVel = -5;		
		 
		y += yVel;
		//for paddle to stay in screen
		if(y < 0) {
			y = 0;
		}
		if(y > 490) {
			y = 490;
		}
		 
	}
	public int getY() {
		return (int)y;
	}
}
