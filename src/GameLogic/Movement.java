package GameLogic;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Animals.Dog;
import Gui.Frame;

public class Movement {
	
	private static Random random = new Random();
	private static final int VELOCITY = 50;

	
	public static int getVelocity() {
		return VELOCITY;
	}
	
	
	public static void updatePosition(JPanel area, JLabel label, int code) {
		switch(code) {
		case 87, 38: 
			if (label.getY() > 0) {
				label.setLocation(label.getX(), label.getY() - Movement.getVelocity());			// w
			} else { Collision.checkBorderCollision(label, 'w'); }
			break;
		case 65, 37: 
			if (label.getX() > 0) {
				label.setLocation(label.getX() -  Movement.getVelocity(), label.getY());		// a
			} else { Collision.checkBorderCollision(label, 'a'); }
			break;
		case 83, 40: 
			if (label.getY() < area.getHeight() - label.getHeight()) {
				label.setLocation(label.getX(), label.getY() +  Movement.getVelocity());		// s
			} else { Collision.checkBorderCollision(label, 's'); }
			break;
		case 68, 39: 
			if (label.getX() < area.getWidth() - label.getWidth()) {
				label.setLocation(label.getX() +  Movement.getVelocity(), label.getY());		// d
			} else { Collision.checkBorderCollision(label, 'd'); }
			break;
		default:
			break;
		}
	}
	
	public static void updateDogPosition(JLabel cat, List<Dog> dogList) {
		for (Dog dog : dogList) {
			Point oldLocation = dog.getLocation();
			Point newLocation = oldLocation;
			
			if (Math.abs(cat.getY() - dog.getY()) <= 100 && Math.abs(cat.getX() - dog.getX()) <= 100) {
				if (cat.getY() != dog.getY()) {
					if (cat.getY() < dog.getY()) {
						newLocation.y -= VELOCITY;
					} else { newLocation.y += VELOCITY; }
				} else if (cat.getX() != dog.getX()) {
					if (cat.getX() < dog.getX()) {
						newLocation.x -= VELOCITY;
					} else { newLocation.x += VELOCITY; }
				}
				dog.setLocation(newLocation);
			} else {
				updatePosition(Frame.getArea(), dog, random.nextInt(38, 40));
			}
			
			for (Dog otherDog : dogList) {
				
				if (dog.getIdentifier() != otherDog.getIdentifier()) {
					while (dog.getLocation().equals(otherDog.getLocation())) {
						updatePosition(Frame.getArea(), dog, random.nextInt(38, 40));
					}
				}
			}
		}
	}
	
	
	public static void updateMousePosition(JLabel mouse, JLabel cat) {
		Point oldLocation = mouse.getLocation();
		Point newLocation = oldLocation;
		while (oldLocation.equals(newLocation) || newLocation.equals(cat.getLocation())) {
			newLocation = new Point(random.nextInt(0, 10) * 50, random.nextInt(0, 10) * 50);
		}
		mouse.setLocation(newLocation);
	}
	



}
