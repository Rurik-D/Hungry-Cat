package GameLogic;

public class Statistics {
	private int points = 0;
	private int lifes = 3;
	
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
		this.lifes -= 1;
	}
}
