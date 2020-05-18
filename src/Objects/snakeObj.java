package Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.Main;

public class snakeObj{

	public static final int width = 15;
	public static final int height = 15;
	private static Random randm = new Random();
	
	private boolean move[];
	public int speed = 15;
	public int x;
	public int y;
	public int points = 0;
	public int pos;
	public List<snakeObj> snake;
	
	public snakeObj(int x, int y) {
		this.x = x;
		this.y = y;
		this.move = new boolean[4];
		this.pos = 0;
		this.snake = new ArrayList<snakeObj>();
		
		this.move[0] = true; // UP
		this.move[1] = false; // DOWN
		this.move[2] = false; // LEFT
		this.move[3] = false; // RIGHT
		
		this.snake.add(this);
	}
	
	private snakeObj(int x, int y, int pos) {
		this.x = x;
		this.y = y;
		this.pos = pos;
	}
	
	public int returnMovement() {
		
		if(this.move[0] == true) {
			return 0;
		}else if(this.move[1] == true) {
			return 1;
		}else if(this.move[2] == true) {
			return 2;
		}else if(this.move[3] == true) {
			return 3;
		}
		
		return -1;
	}
	
	public void resetMovement() {
		this.move[0] = false; // UP
		this.move[1] = false; // DOWN
		this.move[2] = false; // LEFT
		this.move[3] = false; // RIGHT
	}
	
	public void UP() {
		if(this.move[0] != true && this.move[1] != true) {
		resetMovement();
		this.move[0] = true;
		}
	}
	
	public void DOWN() {
		if(this.move[1] != true && this.move[0] != true) {
		resetMovement();
		this.move[1] = true;
		}
	}
	
	public void LEFT() {
		if(this.move[2] != true && this.move[3] != true) {
		resetMovement();
		this.move[2] = true;
		}
	}
	
	public void RIGHT() {
		if(this.move[3] != true && this.move[2] != true) {
		resetMovement();
		this.move[3] = true;
		}
	}
	
	
	private void addSnake(snakeObj s) {
		this.snake.add(s);
	}
	
	public void eat() {
		int snakeSize = this.snake.size()-1;
		snakeObj tail = this.getSnakes()[snakeSize];
		int lastX = tail.x, lastY = tail.y;
		
		if(this.move[0] == true) {			//UP -
			lastY = tail.y - this.speed;
		}else if(this.move[1] == true) {	//DOWN + 
			lastY = tail.y + this.speed;
		}else if(this.move[2] == true) {	//LEFT -
			lastX = tail.x - this.speed;
		}else if(this.move[3] == true) {	//RIGHT +
			lastX = tail.x + this.speed;
		}
		
		
		snakeObj newSnake = new snakeObj(lastX, lastY, snakeSize);
		
		this.addSnake(newSnake);

		points = points+10;
		
//		if(this.speed < 10) {
//		this.speed = this.speed+1;
//		}	
		
	}
	
	private snakeObj[] getSnakes() {
		
		int size = this.snake.size();
		
		snakeObj snakes [] = new snakeObj [size];
		
		for(int i = 0; i < size; i++) {
			snakes[i] = this.snake.get(i);
		}
		return snakes;
	}
	
	
	public void updatePositions() {
		int size = this.snake.size()-1;
		
		for(int i = size; i > 0; i--) {
			this.snake.get(i).x = this.snake.get(i-1).x;
			this.snake.get(i).y = this.snake.get(i-1).y;
		}

	}
	
	private boolean checkCollide() {
		int size = this.snake.size()-1;
		
		for(int i = size; i > 2; i--) {
			if(this.snake.get(0).x == this.snake.get(i).x && this.snake.get(0).y == this.snake.get(i).y) {
				return true;
			}
		}
		return false;
	}
	
	public int checkStatus(fruit f) {
		int rx, ry;
		
		if(this.snake.get(0).x > Main.frameWidth) {
			this.snake.get(0).x = 0;
		}else if(this.snake.get(0).x < 0) {
			this.snake.get(0).x = 800;
		}
		
		if(this.snake.get(0).y > Main.frameHeight) {
			this.snake.get(0).y = 0;
		}else if(this.snake.get(0).y < 0) {
			this.snake.get(0).y = 600;
		}
		
		if(this.snake.get(0).x == f.x && this.snake.get(0).y == f.y) {
			eat();
			do {
			 rx = randm.nextInt(750);
			}while(rx%this.speed != 0);
			
			do {
			 ry = randm.nextInt(550);
			}while(ry%this.speed != 0);
			
			f.x = rx;
			f.y = ry;
			return 1;
		}
		
		
		if(this.checkCollide() == true) {
			return 0;
		}
		
		return -1;
	}
	
}
