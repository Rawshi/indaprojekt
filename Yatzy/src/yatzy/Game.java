package yatzy;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {

	static Color gameColor = new Color(85, 140, 47);

	public static void main(String args[]) {
		createGameGUI();
	}

	private static void createGameGUI() {
		// Custom button text
		Object[] options = { "One Player", "Two Players", "More.." };
		int players = JOptionPane.showOptionDialog(null,
				"How many players are there?", "Yatzy",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[2]);

		if (players > 1) {
			players = Integer.parseInt(JOptionPane.showInputDialog("How many?"));
			players -= 1; // to work together with all the other buttons. 
		}
		if (players < 0) {
			System.exit(0);
		}
		
		JFrame gameField = new JFrame("Yatzy");
		gameField.setResizable(false);
		GamePanel gameBackground = new GamePanel();
		Scoresheet gameBorder2 = new Scoresheet(players+2, gameBackground);

		gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameField.setSize(400 + (40 * (players+2)), 600);

		gameBorder2.setBackground(gameColor);
		gameBackground.setBackground(Color.white);
		gameBackground.setBorder(BorderFactory.createLineBorder(gameColor, 7));

		gameField.add(gameBorder2, BorderLayout.CENTER);
		gameField.add(gameBackground, BorderLayout.WEST);

		gameField.setVisible(true);
		gameBackground.repaint();
	}
}
