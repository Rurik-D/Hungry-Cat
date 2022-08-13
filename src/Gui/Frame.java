package Gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Animals.Cat;
import Animals.Dog;
import GameLogic.*;

public class Frame extends JFrame implements KeyListener{
	private Rectangle areaRect = new Rectangle(43, 80, 500, 500);
	private static Rectangle boxRect = new Rectangle(0, 0, 50, 50);
	private static JPanel area = new JPanel();
	private Random random = new Random();
	private ImageIcon imageIcon;
	private Cat cat = new Cat();
	private JLabel mouse;
	private JLabel grid;
	private JLabel pictureFrame;
	private Statistics stats = new Statistics();
	private List<Dog> dogList = new ArrayList<>();
	
	public Frame() {
		BufferedImage mouseImg = null;
		BufferedImage gridImg = null;
		BufferedImage pictureFrameImg = null;
		
		try {
			mouseImg = ImageIO.read(new File("Assets/Images/mouse.png"));
			gridImg = ImageIO.read(new File("Assets/Images/grid.png"));
			pictureFrameImg = ImageIO.read(new File("Assets/Images/pictureFrame.png"));
			
			imageIcon = new ImageIcon(mouseImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			mouse = new JLabel(imageIcon);
			
			imageIcon = new ImageIcon(gridImg.getScaledInstance(500, 500, Image.SCALE_SMOOTH));
			grid = new JLabel(imageIcon);
			
			imageIcon = new ImageIcon(pictureFrameImg.getScaledInstance(520, 520, Image.SCALE_SMOOTH));
			pictureFrame = new JLabel(imageIcon);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setLayout(null);
		this.setTitle("GameProject");
		this.setBounds(400, 150, 600, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.GRAY.darker().darker());
		this.addKeyListener(this);
		this.getContentPane().add(area);
		this.getContentPane().add(pictureFrame);
		this.getContentPane().setVisible(true);
		this.setVisible(true);
		
		dogList.add(new Dog());
		dogList.get(0).dogSpawn(area, cat, mouse, dogList);
		
		cat.catSpawn(area);
		
		pictureFrame.setBounds(33, 70, 520, 520);
		pictureFrame.setOpaque(false);
		pictureFrame.setVisible(true);
		
		area.setLayout(null);
		area.setBounds(areaRect);
		area.setOpaque(true);
		area.setBackground(Color.WHITE.darker());
		area.setVisible(true);
		
		mouse.setBounds(boxRect);
		Movement.updateMousePosition(mouse, cat);
		mouse.setOpaque(false);
		mouse.setVisible(true);
		mouse.setLocation(random.nextInt(0, 10) * 50, random.nextInt(0, 10) * 50);
		area.add(mouse);
		
		grid.setBounds(0, 0, 500, 500);
		grid.setOpaque(false);
		grid.setVisible(true);
		area.add(grid);
		
	}
	
	public JFrame getFrame() {
		return this;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Movement.updateDogPosition(cat, dogList);
		Movement.updatePosition(area, cat, e.getKeyCode());
		if (cat.getX() == mouse.getX() && cat.getY() == mouse.getY()) {
			stats.increasePoints();
			if (Math.pow(2, dogList.size()) == stats.getPoints()) {
				dogList.add(new Dog());
				dogList.get(dogList.size() - 1).dogSpawn(area, cat, mouse, dogList);
				area.remove(grid);
				area.add(grid);
			}
			System.out.println("Points = " + stats.getPoints());
			Movement.updateMousePosition(mouse, cat);
		}
		Collision.checkDogCollision(cat, dogList);
		
	}
	
	public static JPanel getArea() {
		return area;
	}

	public static Rectangle getBoxRect() {
		return boxRect;
	}

}
