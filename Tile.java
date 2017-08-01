import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Random;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import javax.imageio.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.*;

/**@author senecafriend*/


public class Tile extends JPanel{

	/**This constructor sets up each tile as an object containing its letter, point value, and associated
	 * tile image*/

	public Tile(String letter, int pointValue) {
		tileLetter = letter;
		letterPoint = pointValue;
		String fileName = letter + ".png";
		try {
			image = ImageIO.read(new File(fileName));
		} 
		catch (IOException e) {
		}
	}

	public String getString(){
		return tileLetter;
	}

	public String toString(){
		return ("The tile's letter is: " + tileLetter + " and it has the point value: " 
				+ Integer.toString(letterPoint));
	}

	public void displayImage(JFrame frame){
		String imageLocation = "/Scrabble Images/" + tileLetter + ".png";
		ImageIcon icon = new ImageIcon(this.getClass().getResource(imageLocation));
		button = new JButton(icon);
		button.setContentAreaFilled(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setLocation(600, 600);
		//JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setSize(1280,729);
		frame.getContentPane().add(button);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DraggedButton db = new DraggedButton(button, frame);
		frame.getContentPane().add(db);
	}


	private String tileLetter;
	private Integer letterPoint;
	private BufferedImage image;
	private JButton button;
	private MouseEvent e;

}
