package Animals;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gui.Frame;

public class Cat extends JLabel{
	private JLabel cat;
	private Random random = new Random();
	//private List<Dog> dogList = Frame
	
	public Cat() {
		BufferedImage catImg = null;
		
		try {
			catImg = ImageIO.read(new File("Assets/Images/cat.png"));
			ImageIcon imageIcon = new ImageIcon(catImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			cat = new JLabel(imageIcon);
			cat.setBounds(Frame.getBoxRect());
			cat.setOpaque(false);
			cat.setVisible(true);
			
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	public void catSpawn(JPanel area) {
		catRandomPosition();
		area.add(cat);
	}
	public void catRandomPosition() {
		boolean occupied = true;
		cat.setLocation(random.nextInt(0, 10) * 50, random.nextInt(0, 10) * 50);
//		while (occupied) {
//			for (Dog dog : dogList) {
//		}
	}
	
	@Override
	public void setLocation(int x, int y) {
		cat.setLocation(x, y);
	}
	
	@Override
	public Point getLocation() {
		return cat.getLocation();
	}
	
	@Override
	public int getX() {
		return cat.getX();
	}
	
	@Override
	public int getY() {
		return cat.getY();
	}
	
	@Override
	public int getHeight() {
		return cat.getHeight();
	}
	
	@Override
	public int getWidth() {
		return cat.getWidth();
	}
}
