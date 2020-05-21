package main;

import java.awt.Color;
import javax.swing.Timer;

import javax.swing.JFrame;

import Objects.GameCanvas;
import Objects.fruit;
import Objects.snakeObj;
import control.GameLoop;
import control.inputHandler;

public class Main extends JFrame {
//Feito por C�cero Alves Duarte Filho
	
	public static int frameWidth = 600;
	public static int frameHeight = 800;
	public static String Title = "Snake Game by Cicero Alves Duarte Filho - Points: ";
	
	public static void main(String[] Args) {
		snakeObj s = new snakeObj(0, 0);
		fruit f = new fruit(s);
		
		new Main(s, f);
	}
	
	public Main(snakeObj snake, fruit fruit) {

		GameCanvas c = new GameCanvas(snake, fruit);
		inputHandler h = new inputHandler();
		GameLoop loop = new GameLoop(c, snake, fruit, this);
        Timer timer = new Timer(60, loop);
        h.addListener(c, snake);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setTitle(Title);
		add(c);
		setLocationRelativeTo(null);
		setVisible(true);
		
		timer.start();
		
		
	}
	
}
