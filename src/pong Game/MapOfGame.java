package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
 

public class MapOfGame  extends JPanel implements KeyListener, ActionListener{
	 
	private static final long serialVersionUID = 1L;
	
	static int width = 700 , height = 600;
	private Timer timer;
	private int delay = 8;
	boolean GameStart;
	static int score = 0, lable = 1;
	
	Paddle p1;
	AIpaddle p2;
	Boll b1;
	public MapOfGame() {
 		addKeyListener(this);
 		
 		GameStart = false;
  	
 		p1 = new Paddle(1);
  		b1 = new Boll();
  		p2 = new AIpaddle(2, b1);
 		
  		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		 
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		g.drawString("",150,10);
		
//		show the Game over String
		if(b1.getX()< -10 || b1.getX() > 710) {
			GameStart = false;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Lable: " + lable,250,130);
			g.drawString("Score: " + score,330,130);
			g.drawString("Game Over", 270, 170);
			g.drawString("Press Enter to Restart.", 230, 200);	
			lable = 1;
			score = 0;
		}else if(!GameStart) {
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("You can use UP and DOWN key to play the game.", 150, 250);
			g.drawString("Press Enter to Start.", 230, 300);
		}else {
			p1.draw(g);
			b1.draw(g);
			p2.draw(g);
		}
		 
		g.dispose();
	}	 
 
	public void actionPerformed(ActionEvent e) {
	       
		timer.start(); 
		if(GameStart) {
		    p1.move(); 
			p2.move();
			b1.move();
			b1.paddleCollision(p1, p2);
		}
		repaint();
	  }
	
	//All Key Events
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
 
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpDir(true);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) { 
				p1.setDounDir(true);
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				GameStart = true;
				p1 = new Paddle(1);
		  		b1 = new Boll();
		  		p2 = new AIpaddle(2, b1);
				repaint();
		}
	}
 
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpDir(false);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDounDir(false);
		} 
	}

}  
