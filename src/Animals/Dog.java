package Animals;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gui.Frame;

public class Dog extends JLabel{
	private JLabel dog;
	private Random random = new Random();
	private final int identifier = random.nextInt(-1000000, 100000);

	public Dog() {
		BufferedImage dogImg = null;
		
		try {
			dogImg = ImageIO.read(new File("Assets/Images/dog.png"));
			ImageIcon imageIcon = new ImageIcon(dogImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			dog = new JLabel(imageIcon);
			
		} catch (IOException e) {
			e.printStackTrace();
			}
		
		dog.setBounds(Frame.getBoxRect());
		dog.setOpaque(false);
		dog.setVisible(true);
		

	}


	public JLabel getDogLable() {
		return dog;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public void dogSpawn(JPanel area, JLabel cat, JLabel mouse, List<Dog> dogList) {
		Point oldLocation = dog.getLocation();
		Point newLocation = oldLocation;
		boolean occupied = true;

		while ( occupied ) {
			occupied = false;
			dog.setLocation(random.nextInt(0, 10) * 50, random.nextInt(0, 10) * 50);
			newLocation = dog.getLocation();
			if (newLocation.equals(oldLocation) || newLocation.equals(cat.getLocation()) || newLocation.equals(mouse.getLocation())) {
				occupied = true;
			}
			
			for (Dog dogInList : dogList) {
				if (dogInList.getIdentifier() == this.getIdentifier()) {
					continue;
				}
				if (newLocation.equals(dogInList.getDogLable().getLocation())) {
					occupied = true;
					break;
				}
			}
		area.add(dog);
		}
	}
}

