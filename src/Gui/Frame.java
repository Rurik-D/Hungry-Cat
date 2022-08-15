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
	private static JPanel mainPanel = new JPanel();
	private static JPanel area = new JPanel();
	private Random random = new Random();
	private ImageIcon imageIcon;
	private Cat cat = new Cat();
	private JLabel mouse;
	private JLabel grid;
	private JLabel pictureFrame;
	private JLabel points;
	private JLabel lifes;
	private Statistics stats = new Statistics();
	private List<Dog> dogList = new ArrayList<>();
	private static Numbers pointsCounter = new Numbers(mainPanel, "points");
	private static Numbers lifesCounter = new Numbers(mainPanel, "lifes");

	
	public Frame() {
		BufferedImage mouseImg = null;
		BufferedImage gridImg = null;
		BufferedImage pictureFrameImg = null;
		BufferedImage pointsImg = null;
		BufferedImage lifesImg = null;
		
		try {
			mouseImg = ImageIO.read(new File("Assets/Images/mouse.png"));
			gridImg = ImageIO.read(new File("Assets/Images/grid.png"));
			pictureFrameImg = ImageIO.read(new File("Assets/Images/pictureFrame.png"));
			pointsImg = ImageIO.read(new File("Assets/Images/points.png"));
			lifesImg = ImageIO.read(new File("Assets/Images/lifes.png"));

			imageIcon = new ImageIcon(mouseImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			mouse = new JLabel(imageIcon);
			
			imageIcon = new ImageIcon(gridImg.getScaledInstance(500, 500, Image.SCALE_SMOOTH));
			grid = new JLabel(imageIcon);
			
			imageIcon = new ImageIcon(pictureFrameImg.getScaledInstance(520, 520, Image.SCALE_SMOOTH));
			pictureFrame = new JLabel(imageIcon);
			
			imageIcon = new ImageIcon(pointsImg.getScaledInstance(183, 60, Image.SCALE_SMOOTH));
			points = new JLabel(imageIcon);
			
			imageIcon = new ImageIcon(lifesImg.getScaledInstance(153, 60, Image.SCALE_SMOOTH));
			lifes = new JLabel(imageIcon);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setLayout(null);
		this.setTitle("GameProject");
		this.setBounds(400, 150, 600, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.GRAY.darker().darker());
		this.getContentPane().setVisible(true);

		this.getContentPane().add(mainPanel);
		mainPanel.setBounds(0, 0, 600, 650);
		mainPanel.add(area);
		mainPanel.add(pictureFrame);
		mainPanel.setOpaque(false);
		mainPanel.setVisible(true);
		
		points.setBounds(27, 10, 183, 60);
		points.setVisible(true);
		mainPanel.add(points);
		
		
		pointsCounter.getNumber('0').setVisible(true);
		
		
		lifes.setBounds(325, 10, 153, 60);
		lifes.setVisible(true);
		mainPanel.add(lifes);
		//lifesCounter = new Numbers(mainPanel, "lifes");
		
		lifesCounter.getNumber('3').setVisible(true);
		
		dogList.add(new Dog());
		dogList.get(0).dogSpawn(area, cat, mouse, dogList);
		
		cat.catSpawn(area);
		
		pictureFrame.setBounds(33, 70, 520, 520);
		pictureFrame.setVisible(true);
		
		area.setLayout(null);
		area.setBounds(areaRect);
		area.setOpaque(true);
		area.setBackground(Color.WHITE.darker());
		area.setVisible(true);
		
		mouse.setBounds(boxRect);
		Movement.updateMousePosition(mouse, cat);
		mouse.setVisible(true);
		mouse.setLocation(random.nextInt(0, 10) * 50, random.nextInt(0, 10) * 50);
		area.add(mouse);
		
		grid.setBounds(0, 0, 500, 500);
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
		Movement.updatePosition(area, cat, e.getKeyCode());
		Movement.updateDogPosition(cat, dogList);
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
	
	public static Numbers getPointsCounter() {
		return pointsCounter;
	}
	
	public static Numbers getLifesCounter() {
		return lifesCounter;
	}

}
