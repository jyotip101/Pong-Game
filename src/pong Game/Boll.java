package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Boll {

	private Random r;
	double xVel, yVel, x, y;
	public Boll() {
		r = new Random();
		x = r.nextInt(MapOfGame.width);
		y = r.nextInt(MapOfGame.height);;
		xVel = 2;
		yVel = 1;
		 
 	} 
	
	public void draw(Graphics g) {
		//Draw boll 
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int)y-10, 20, 20);
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 20));
		g.drawString("Lable: " + MapOfGame.lable,15,20);
		g.drawString("Score: " + MapOfGame.score,90,20);
		
	}
	public void move() {
		x += xVel;
		y += yVel;
//	when boll heat top and bottom
		//top heat
		if(y < 10) 
			yVel = -yVel;
		//bottom heat	    
		if(y > 550) 
			yVel = -yVel; 
	}
	public void paddleCollision(Paddle p1, AIpaddle p2) {
	//  when paddle heat
		//for left
			if(x  <= 40) {
				if(y >= p1.getY() && y <= p1.getY() + 80) {
					xVel = -xVel;
					
					MapOfGame.score += 01;
					
					if(MapOfGame.score == 100) {
						MapOfGame.lable += 1;
						
						//speed of Boll
						xVel = 4;
						yVel = 2;
						
						if(MapOfGame.score == 200) {
							MapOfGame.lable += 1;
							
							//speed of Boll
							xVel = 8;
							yVel = 3;
							
							if(MapOfGame.score == 300) {
								MapOfGame.lable += 1;
								
								//speed of Boll
								xVel = 10;
								yVel = 4;
							}
						}
						
					}
				}
		//for right
			}else if(x >= 640) {
				if(y >= p2.getY() && y <= p2.getY() + 80) {
					xVel = -xVel;
				}
			}
	} 
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
}