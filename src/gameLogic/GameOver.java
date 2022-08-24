package gameLogic;

import gui.Sounds;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.Frame;
	
public class GameOver {
	private static JLabel gameOvLbl = new JLabel();
	private static Statistics stats = new Statistics();
	private static BufferedImage mouseImg = null;
	
	private static void printGameOverLbl() {
		try {
			mouseImg = ImageIO.read(new File("Assets/Images/GameOver.png"));
			ImageIcon imageIcon = new ImageIcon(mouseImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			gameOvLbl = new JLabel(imageIcon);
			Frame.getMainPanel().add(gameOvLbl);
			gameOvLbl.setVisible(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkGameOver() {
		if (stats.getLifes() <= 0) {
			Sounds.stopBgSong();
			Frame.stopRun();
			printGameOverLbl();
			Frame.refresh();
		}
	}
	
	private void endGame() {
		
	}
	
}

