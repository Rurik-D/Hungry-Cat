package gui;

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

import animals.*;
import gameLogic.*;

public class Frame extends JFrame implements KeyListener{
	private Rectangle areaRect = new Rectangle(43, 80, 500, 500);
	private static Rectangle boxRect = new Rectangle(0, 0, 50, 50);
	private static JPanel mainPanel = new JPanel();
	private static JPanel area = new JPanel();
	private Random random = new Random();
	private ImageIcon imageIcon;
	private Cat cat = new Cat();
	private JLabel mouse;
	private static JLabel grid;
	private JLabel pictureFrame;
	private JLabel points;
	private JLabel lifes;
	private Statistics stats = new Statistics();
	private List<Dog> dogList = new ArrayList<>();
	private static Numbers pointsUnits = new Numbers(mainPanel, "points", 0);
	private static Numbers pointsTens = new Numbers(mainPanel, "points", 1);
	private static Numbers lifesUnits = new Numbers(mainPanel, "lifes", 0);
	private static Numbers lifesTens = new Numbers(mainPanel, "lifes", 1);
	private static boolean run = true;

	
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
		this.setTitle("Hungry Cat!");
		this.setName("Hungry Cat!");
		this.setBounds(400, 150, 600, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.GRAY.darker().darker());
		this.getContentPane().setVisible(true);
		this.getContentPane().add(mainPanel);
		
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 600, 650);
		mainPanel.add(area);
		mainPanel.add(pictureFrame);
		mainPanel.setOpaque(false);
		mainPanel.setVisible(true);
		
		points.setBounds(27, 10, 183, 60);
		points.setVisible(true);
		mainPanel.add(points);
		
		pointsUnits.getNumber("0");
		pointsTens.getNumber("0");
		
		lifes.setBounds(325, 10, 153, 60);
		lifes.setVisible(true);
		mainPanel.add(lifes);
		
		lifesUnits.getNumber("3");
		lifesTens.getNumber("0");
		
		area.add(GameOver.getGameOverLbl()); 

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
		


		
		Sounds.backgroundSong();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		if (run) {
			Movement.updatePosition(area, cat, e.getKeyCode());
			Movement.updateDogPosition(cat, dogList);
			if (cat.getX() == mouse.getX() && cat.getY() == mouse.getY()) {
				Sounds.mouseCatched();
				pointsUnits.increase(String.valueOf(stats.getPoints()));
				if ((stats.getPoints()+1) % 10 == 0) {
					pointsTens.increase("0" + String.valueOf(stats.getPoints()));
				}
				stats.increasePoints();
	
				if (Math.pow(2, dogList.size()) == stats.getPoints()) {
					dogList.add(new Dog());
					dogList.get(dogList.size() - 1).dogSpawn(area, cat, mouse, dogList);
					area.remove(grid);
					area.add(grid);
				}
				Movement.updateMousePosition(mouse, cat);
			}
			Collision.checkDogCollision(cat, dogList);
			
		}
	}
	
	public static JPanel getArea() {
		return area;
	}
	
	public static JPanel getMainPanel() {
		return mainPanel;
	}

	public static Rectangle getBoxRect() {
		return boxRect;
	}
	
	public static Numbers getPointsCounter() {
		return pointsUnits;
	}
	
	public static Numbers getLifesCounter() {
		return lifesUnits;
	}
	
	public static void stopRun() {
		run = false;
	}

	public static void refresh() {
		GameOver.getGameOverLbl().setVisible(true);
	}

}
