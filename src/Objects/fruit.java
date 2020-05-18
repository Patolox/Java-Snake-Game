package Objects;

import java.util.Random;

public class fruit {

	public static final int width = 15;
	public static final int height = 15;
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
			 this.x = randm.nextInt(760) + snake.speed;
			}while(this.x%snake.speed != 0);
			
			do {
			 this.y = randm.nextInt(560) + snake.speed;
			}while(this.y%snake.speed != 0);
	}
	
}
