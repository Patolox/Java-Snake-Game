package Objects;

import java.util.Random;

import main.Main;

public class fruit {

	public static final int width = 10;
	public static final int height = 10;
	
	private Random randm;
	
	public int x;
	public int y;
	
	public fruit(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public fruit(snakeObj snake) {
		this.randm = new Random();
		do {
			 this.x = randm.nextInt(Main.frameWidth/snake.speed)*snakeObj.width;
			 this.y = randm.nextInt(Main.frameHeight/snake.speed)*snakeObj.height;
		}while(this.x < 100 || this.x > Main.frameWidth - 100 || this.y < 100 || this.y > Main.frameHeight - 100);
	}
	
}
