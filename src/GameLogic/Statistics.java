package GameLogic;

import Gui.Frame;
import Gui.Numbers;

public class Statistics {
	private int points = 0;
	private int lifes = 3;
	private Numbers pointsCounter = Frame.getPointsCounter();
	private Numbers lifesCounter = Frame.getLifesCounter();

	
	public int getLifes() {
		return lifes;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void increasePoints() {
		points += 1;
	}
	
	public void decreaseLifes() {
		lifesCounter.getNumber((char) lifes).setVisible(false);
		lifes -= 1;
		lifesCounter.getNumber((char) lifes).setVisible(true);

	}
}
