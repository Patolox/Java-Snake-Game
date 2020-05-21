package Objects;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import main.Main;

public class GameCanvas extends Canvas implements Runnable {

	private snakeObj s;
	private fruit f;
	public boolean running;
	
	public GameCanvas(snakeObj s, fruit f) {
		this.s = s;
		this.f = f;
		this.running = true;
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, Main.frameWidth, Main.frameHeight);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Main.frameWidth, Main.frameHeight);
		
//		g.setColor(Color.white);
//	
//		for(int i = 0; i < Main.frameWidth/s.speed; i++) {
//			g.drawLine(i*s.speed, 0, i*s.speed, Main.frameHeight);
//		}
//		for(int i = 0; i < Main.frameHeight/s.speed; i++) {
//			g.drawLine(0, i*s.speed, Main.frameWidth, i*s.speed);
//		}
	
		
		g.setColor(Color.RED);
		g.fillRect(f.x, f.y, f.width, f.height);
		
		g.setColor(Color.BLUE);
		
		for(int i = 0; i < s.snake.size(); i++) {
		g.fillRect(s.snake.get(i).x, s.snake.get(i).y, s.width, s.height);
		}
		
		//System.out.println("SNAKE: " + i + " X : " + s.snake.get(i).x + " Y: " +  s.snake.get(i).y);

		//g.fillRect(s.x, s.y, s.width, s.height);
	}


	@Override
	public void run() {

	}
	
}
