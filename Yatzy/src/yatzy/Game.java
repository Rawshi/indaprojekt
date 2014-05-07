package yatzy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
	    GamePanel gameBackground = new GamePanel();
	    
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

}
