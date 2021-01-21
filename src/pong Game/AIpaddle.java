package pong;

import java.awt.Color;
import java.awt.Graphics;

public class AIpaddle {
	double y, yVel;
	boolean upDir, downDir;
	int playear, x;
	final double GRAVITY = 0;
	Boll b1;
    public AIpaddle(int playear, Boll b) {
    	upDir = false; downDir = false;
		y = 210; yVel = 0;
		b1 = b;
		//for left paddle to control
		if(playear == 1)
			x = 10;
	    else
	    	x = 660;
	}
	public void draw(Graphics g) {
		g.setColor(Color.yellow );
		//right paddle
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
		 y = b1.getY() - 30;
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
