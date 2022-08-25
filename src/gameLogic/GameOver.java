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
	private static JLabel gameOvLbl = setGameOverLbl();
	private static Statistics stats = new Statistics();
	private static BufferedImage mouseImg = null;
	
	private static JLabel setGameOverLbl() {
		gameOvLbl = new JLabel();
		try {
			mouseImg = ImageIO.read(new File("assets/images/GameOver.png"));
			ImageIcon imageIcon = new ImageIcon(mouseImg.getScaledInstance(313, 60, Image.SCALE_SMOOTH));
			gameOvLbl = new JLabel(imageIcon);
			Frame.getMainPanel().add(gameOvLbl);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		gameOvLbl.setVisible(false);

		gameOvLbl.setBounds(100, 200, 313, 60);
		return gameOvLbl;
	}
	
	public static void checkGameOver() {
		if (stats.getLifes() <= 0) {
			Sounds.stopBgSong();
			Frame.stopRun();
			Frame.refresh();
			gameOvLbl.setVisible(true);
		}
	}
	
	public static JLabel getGameOverLbl() {
		return gameOvLbl;
	}
	
	private void endGame() {
		
	}
	
}

