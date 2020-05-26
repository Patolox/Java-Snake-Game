package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import Objects.GameCanvas;
import Objects.fruit;
import Objects.snakeObj;
import main.Main;

public class GameLoop implements ActionListener {
	
	private static Random randm = new Random();
	
	private GameCanvas c;
	private snakeObj snake;
	private fruit fruit;
	private Main m;
	private int endGame;
	private int points;
	private int level;
	
	public GameLoop(GameCanvas c, snakeObj snake, fruit fruit, Main m) {
		this.c = c;
		this.snake = snake;
		this.fruit = fruit;
		this.m = m;
		this.points = 0;
		this.level = 0;
	}
	
	private void die() {

		snake.snake.get(0).resetMovement();
		snake.snake.get(0).x = -100;
		snake = null;
		m.dispose();
		m = null;
		snakeObj newGame = new snakeObj(0, 0);
		new Main(newGame, new fruit(newGame));
	}
	
	private boolean checkCollide() {
		int size = this.snake.snake.size()-1;
		
		for(int i = size; i > 2; i--) {
			if(this.snake.snake.get(0).x == this.snake.snake.get(i).x && this.snake.snake.get(0).y == this.snake.snake.get(i).y) {
				return true;
			}
		}
		return false;
	}
	
	public int checkStatus(fruit f, int level) {
		int rx, ry;
	if(this.endGame != 0 && this.snake != null) {
		if(this.snake.snake.get(0).x > Main.frameWidth) {
			if(this.level < 5) {
				this.snake.snake.get(0).x = 0;
			}else {
				return 0;
			}
		}else if(this.snake.snake.get(0).x < 0) {
			if(this.level < 5) {
				this.snake.snake.get(0).x = Main.frameWidth;
			}else {
				return 0;
			}
		}
		
		if(this.snake.snake.get(0).y > Main.frameHeight) {
			if(this.level < 5) {
				this.snake.snake.get(0).y = 0;
			}else {
				return 0;
			}
		}else if(this.snake.snake.get(0).y < 0) {
			if(this.level < 5) {
			this.snake.snake.get(0).y = Main.frameHeight;
			}else {
				return 0;
			}
		}
		
		if(this.snake.snake.get(0).x == f.x && this.snake.snake.get(0).y == f.y) {
			this.snake.snake.get(0).eat();
		do {
			 rx = randm.nextInt(Main.frameWidth/snake.speed)*snakeObj.width;
			 ry = randm.nextInt(Main.frameHeight/snake.speed)*snakeObj.height;
		}while(rx < 100 || rx > Main.frameWidth - 100 || ry < 100 || ry > Main.frameHeight - 100);
			f.x = rx;
			f.y = ry;
			return 1;
		}
		
		
		if(this.checkCollide() == true) {
			return 0;
		}
	}
		return -1;
	}
	
	private void snakeMove() {
		if(snake.returnMovement() == 0) {
			snake.y = snake.y-snake.speed;
		}else if(snake.returnMovement() == 1) {
			snake.y = snake.y + snake.speed;
		}else if(snake.returnMovement() == 2) {
			snake.x = snake.x-snake.speed;
		}else if(snake.returnMovement() == 3) {
			snake.x = snake.x+snake.speed;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	     endGame = checkStatus(fruit, level);
		
	if(endGame != 0){
		
		if(endGame == 1) {
			points = points + 100;
			level = points/100;
			m.setTitle(Main.Title + points);
		}
	
	if(snake != null) {
		snake.updatePositions();
		
			snakeMove();
			c.repaint();
	}
			
		}else if(endGame == 0) {
			die();
		}
	}
}
