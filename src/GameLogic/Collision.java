package GameLogic;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Animals.Dog;

public class Collision {

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
	
	public static void checkDogCollision(JLabel cat, List<Dog> dogList) {
		for (Dog dog : dogList) {
			if (cat.getLocation().equals(dog.getDogLable().getLocation())) {
				System.out.println("wof");
			}
	}	}
			
		
}
