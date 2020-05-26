package Objects;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import main.Main;

public class GameCanvas extends Canvas implements Runnable {

	private snakeObj s;
	private fruit f;
	
	public GameCanvas(snakeObj s, fruit f) {
		this.s = s;
		this.f = f;
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, Main.frameWidth, Main.frameHeight);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Main.frameWidth, Main.frameHeight);
		
//		g.setColor(Color.white);
//	
//		for(int i = 0; i < Main.frameWidth/s.speed; i++) {
//			g.drawLine(i*s.width, 0, i*s.width, Main.frameHeight);
//		}
//		for(int i = 0; i < Main.frameHeight/s.speed; i++) {
//			g.drawLine(0, i*s.height, Main.frameWidth, i*s.height);
//		}
	
		
		g.setColor(Color.RED);
		g.fillRect(f.x, f.y, f.width, f.height);
		
		g.setColor(Color.GREEN);
		
		for(int i = 0; i < s.snake.size(); i++) {
		g.fillRect(s.snake.get(i).x, s.snake.get(i).y, s.width, s.height);
		}
		
	}


	@Override
	public void run() {

	}
	
}
