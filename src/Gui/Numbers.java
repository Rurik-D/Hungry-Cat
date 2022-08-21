package Gui;

import java.awt.Container;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Numbers {
	private ImageIcon imageIcon;
	private JLabel n0;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JLabel n5;
	private JLabel n6;
	private JLabel n7;
	private JLabel n8;
	private JLabel n9;
	private final int W = 31;
	private final int H = 40;
	private final int X;
	private final int Y = 27;
	/**
	 * 
	 * @param counterType refears to the Points counter and the Lifes counter.
	 */
	public Numbers(Container container, String counterType) {
		this.X = switch(counterType) {
			case "points" -> 210;
			case "lifes" -> 475;
			default -> 0;
		};
		
		BufferedImage n0Img = null;
		BufferedImage n1Img = null;
		BufferedImage n2Img = null;
		BufferedImage n3Img = null;
		BufferedImage n4Img = null;
		BufferedImage n5Img = null;
		BufferedImage n6Img = null;
		BufferedImage n7Img = null;
		BufferedImage n8Img = null;
		BufferedImage n9Img = null;
		
		try {
			n0Img = ImageIO.read(new File("Assets/Images/0.png"));
			n1Img = ImageIO.read(new File("Assets/Images/1.png"));
			n2Img = ImageIO.read(new File("Assets/Images/2.png"));
			n3Img = ImageIO.read(new File("Assets/Images/3.png"));
			n4Img = ImageIO.read(new File("Assets/Images/4.png"));
			n5Img = ImageIO.read(new File("Assets/Images/5.png"));
			n6Img = ImageIO.read(new File("Assets/Images/6.png"));
			n7Img = ImageIO.read(new File("Assets/Images/7.png"));
			n8Img = ImageIO.read(new File("Assets/Images/8.png"));
			n9Img = ImageIO.read(new File("Assets/Images/9.png"));

			imageIcon = new ImageIcon(n0Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n0 = new JLabel(imageIcon);
			n0.setBounds(X, Y, W, H);
			n0.setVisible(false);
			container.add(n0);
			
			imageIcon = new ImageIcon(n1Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n1 = new JLabel(imageIcon);
			n1.setBounds(X, Y, W, H);
			n1.setVisible(false);
			container.add(n1);

			
			imageIcon = new ImageIcon(n2Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n2 = new JLabel(imageIcon);
			n2.setBounds(X, Y, W, H);
			n2.setVisible(false);
			container.add(n2);
			
			imageIcon = new ImageIcon(n3Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n3 = new JLabel(imageIcon);
			n3.setBounds(X, Y, W, H);
			n3.setVisible(false);
			container.add(n3);
			
			imageIcon = new ImageIcon(n4Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n4 = new JLabel(imageIcon);
			n4.setBounds(X, Y, W, H);
			n4.setVisible(false);
			container.add(n4);
			
			imageIcon = new ImageIcon(n5Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n5 = new JLabel(imageIcon);
			n5.setBounds(X, Y, W, H);
			n5.setVisible(false);
			container.add(n5);
			
			imageIcon = new ImageIcon(n6Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n6 = new JLabel(imageIcon);
			n6.setBounds(X, Y, W, H);
			n6.setVisible(false);
			container.add(n6);
			
			imageIcon = new ImageIcon(n7Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n7 = new JLabel(imageIcon);
			n7.setBounds(X, Y, W, H);
			n7.setVisible(false);
			container.add(n7);
			
			imageIcon = new ImageIcon(n8Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n8 = new JLabel(imageIcon);
			n8.setBounds(X, Y, W, H);
			n8.setVisible(false);
			container.add(n8);
			
			imageIcon = new ImageIcon(n9Img.getScaledInstance(W, H, Image.SCALE_SMOOTH));
			n9 = new JLabel(imageIcon);
			n9.setBounds(X, Y, W, H);
			n9.setVisible(false);
			container.add(n9);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JLabel getNumber(String number) {
		
		return switch (number) {
			case "00" -> n0;
			case "01" -> n1;
			case "02" -> n2;
			case "03" -> n3;
			case "04" -> n4;
			case "05" -> n5;
			case "06" -> n6;
			case "07" -> n7;
			case "08" -> n8;
			case "09" -> n9;
			default -> null;
		};
	}
}
