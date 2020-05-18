package Objects;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class GameCanvas extends Canvas implements Runnable {

	private snakeObj s;
	private fruit f;
	
	public GameCanvas(snakeObj s, fruit f) {
		this.s = s;
		this.f = f;
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(f.x, f.y, f.width, f.height);
		
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
