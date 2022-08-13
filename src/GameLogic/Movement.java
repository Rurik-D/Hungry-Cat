package GameLogic;

import java.awt.Point;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Gui.Frame;

public class Movement {
	
	private static Random random = new Random();
	private static final int VELOCITY = 50;

	
	public static int getVelocity() {
		return VELOCITY;
	}
	
	
	public static void updatePosition(JPanel area, JLabel cat, int code) {
		switch(code) {
		case 87, 38: 
			if (cat.getY() > 0) {
				cat.setLocation(cat.getX(), cat.getY() - Movement.getVelocity());		// w
			} else { Collision.checkBorderCollision(cat, 'w'); }
			break;
		case 65, 37: 
			if (cat.getX() > 0) {
				cat.setLocation(cat.getX() -  Movement.getVelocity(), cat.getY());		// a
			} else { Collision.checkBorderCollision(cat, 'a'); }
			break;
		case 83, 40: 
			if (cat.getY() < area.getHeight() - cat.getHeight()) {
				cat.setLocation(cat.getX(), cat.getY() +  Movement.getVelocity());		// s
			} else { Collision.checkBorderCollision(cat, 's'); }
			break;
		case 68, 39: 
			if (cat.getX() < area.getWidth() - cat.getWidth()) {
				cat.setLocation(cat.getX() +  Movement.getVelocity(), cat.getY());		// d
			} else { Collision.checkBorderCollision(cat, 'd'); }
			break;
		default:
			break;
		}
	}
	
	public static void updateDogPosition(JLabel cat, JLabel dog) {
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
