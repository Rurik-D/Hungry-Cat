package GameLogic;

import Gui.Frame;
import Gui.Numbers;

public class Statistics {
	private int points = 0;
	private int lifes = 3;
	private Numbers pointsUnits = Frame.getPointsCounter();
	private Numbers lifesUnits = Frame.getLifesCounter();

	
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
		lifesUnits.decrease("" + lifes);
		lifes -= 1;
	}
}
