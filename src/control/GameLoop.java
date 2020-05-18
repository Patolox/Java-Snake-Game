package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Objects.GameCanvas;
import Objects.fruit;
import Objects.snakeObj;
import main.Main;

public class GameLoop implements ActionListener {

	private GameCanvas c;
	private snakeObj snake;
	private fruit fruit;
	private Main m;
	
	public GameLoop(GameCanvas c, snakeObj snake, fruit fruit, Main m) {
		this.c = c;
		this.snake = snake;
		this.fruit = fruit;
		this.m = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("X DA COBRA: " + snake.x + " Y DA COBRA: " + snake.y + "X DA FRUTA: " + this.fruit.x + "Y DA FRUTA: " + this.fruit.y);

		int endGame = snake.checkStatus(fruit);
		
		if(endGame == 0){
			m.setVisible(false);
			m.dispose();
			snakeObj newGame = new snakeObj(snake.x, snake.y);
			m = new Main(newGame, new fruit(newGame));
			m.toFront();
			m.requestFocusInWindow();
		}
		
		if(endGame == 1) {
			m.setTitle(Main.Title + snake.points);
		}

		snake.updatePositions();
		
			if(snake.returnMovement() == 0) {
				snake.y = snake.y-snake.speed;
				c.repaint();
			}else if(snake.returnMovement() == 1) {
				snake.y = snake.y + snake.speed;
				c.repaint();
			}else if(snake.returnMovement() == 2) {
				snake.x = snake.x-snake.speed;
				c.repaint();
			}else if(snake.returnMovement() == 3) {
				snake.x = snake.x+snake.speed;
				c.repaint();
			}
			
	}
}
