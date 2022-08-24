package gameLogic;

import java.util.List;
import javax.swing.JLabel;

import animals.*;
import gui.Sounds;

public class Collision {
	private static Statistics stats = new Statistics();
	
	public static void checkBorderCollision(JLabel cat, char code) {
		switch (code) {
			case 'w': cat.setLocation(cat.getX(), 9 *  Movement.getVelocity());
				break;
			case 'a': cat.setLocation(9 *  Movement.getVelocity(), cat.getY());
				break;
			case 's': cat.setLocation(cat.getX(), 0);
				break;
			case 'd': cat.setLocation(0, cat.getY());
				break;
		}
	}
	
	public static void checkDogCollision(Cat cat, List<Dog> dogList) {
		for (Dog dog : dogList) {
			if (cat.getLocation().equals(dog.getDogLable().getLocation())) {
				stats.decreaseLifes();
				cat.catRandomPosition();
				Sounds.catCatched();
				GameOver.checkGameOver();
				break;
			}
		}
	}
		
}
