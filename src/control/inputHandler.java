package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Objects.GameCanvas;
import Objects.snakeObj;

public class inputHandler{
	

	public inputHandler() {}
	
	public void addListener(GameCanvas c, snakeObj snake) {
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					snake.DOWN();
					
				}else if(e.getKeyCode() == KeyEvent.VK_UP) {
					c.repaint();
					snake.UP();
					
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					snake.LEFT();
					
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					snake.RIGHT();
				}
					
			}
		});
	}


}