package yatzy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
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
			setBorder(BorderFactory.createLineBorder(Color.black));
		 GridBagConstraints c = new GridBagConstraints();	
		 Image image= Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
		 ImageIcon icon = new ImageIcon(image);
		 
		 
		 JToggleButton dice1 = new JToggleButton();
		 JToggleButton dice2 = new JToggleButton();
		 JToggleButton dice3 = new JToggleButton();
		 JToggleButton dice4 = new JToggleButton();
		 JToggleButton dice5 = new JToggleButton();
	
		 dice1.setIcon(icon);
		 dice2.setIcon(icon);
		 dice3.setIcon(icon);
		 dice4.setIcon(icon);
		 dice5.setIcon(icon);
		 
		 add(dice1);
		 add(dice2);
		 add(dice3);
		 add(dice4);
		 add(dice5);
		 
		}
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);

		   // Image dice1 = Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
		    
			// g.drawImage(dice1, 150, 10, this);


		}
	}
}
