package yatzy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGameGUI();

			}
		});

	}

	private static void createGameGUI(){
		JOptionPane.showInputDialog("Derp");
		JFrame gameField = new JFrame("Yatzy");
		JPanel gameBorder = new JPanel();
	    JPanel gameBorder2 = new JPanel();
	    Game.GamePanel gameBackground = new Game.GamePanel();
	    
		gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameField.setSize(850,600);
		
		gameBorder.setBackground(Color.green);
		gameBorder2.setBackground(Color.green);
		gameBackground.setBackground(Color.white);
		
		gameField.add(gameBorder, BorderLayout.WEST);
		gameField.add(gameBorder2, BorderLayout.EAST);
		gameField.add(gameBackground, BorderLayout.CENTER);
		
		
		gameField.setVisible(true);
		gameBackground.repaint();

	}

	private static void play(int players) {
		
	}


	static class GamePanel extends JPanel {
		public GamePanel() {
			setBorder(BorderFactory.createLineBorder(Color.white));
		    
		}
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);

		    Image dice1 = Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
		    Image dice2 = Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
		    Image dice3 = Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
			g.setColor(Color.white);
			g.fillRect(10,10,50,50);
			g.drawImage(dice1, 150, 10, this);
			g.drawImage(dice2, 150, 120, this);
			g.drawImage(dice3, 150, 230, this);


		}
	}
}
