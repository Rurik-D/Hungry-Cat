package gameLogic;

import gui.*;

public class Statistics {
	private static int points = 0;
	private static int lifes = 3;
	private Numbers pointsUnits = Frame.getPointsCounter();
	private Numbers lifesUnits = Frame.getLifesCounter();

	
	public int getLifes() {
		return lifes;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void increasePoints() {
		this.points += 1;
	}
	
	public void decreaseLifes() {
		lifesUnits.decrease("" + lifes);
		lifes -= 1;
	}
}
