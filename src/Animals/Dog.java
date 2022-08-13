package Animals;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gui.Frame;

public class Dog extends JLabel{
	private JLabel dog;
	private Random random = new Random();

	public Dog(JPanel area) {
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
		dog.setLocation(random.nextInt(0, 10) * 50, random.nextInt(0, 10) * 50);
		area.add(dog);

	}
	
	public JLabel getDogLable() {
		return dog;
	}
}

