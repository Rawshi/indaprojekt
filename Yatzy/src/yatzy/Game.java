package yatzy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game {


	public static void main(String args[]) {
		Dice[] dice = new Dice[5];
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGameGUI();

			}
		});

	}

	private static void createGameGUI(){
		JFrame gameField = new JFrame("Yatzy");
		GamePanel gameBackround = new GamePanel();
		gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameField.setSize(850,600);
		gameField.add(gameBackround);
		gameBackround.setLayout(new BorderLayout());
		JPanel startMenu = new JPanel(new GridLayout(4,1));
		JButton onePlayer = new JButton("Tryck på mig ples");
		JButton twoPlayer = new JButton("Tryck på mig kanske?");
		gameBackround.add(startMenu, BorderLayout.WEST);
		startMenu.add(onePlayer, BorderLayout.WEST);
		startMenu.add(twoPlayer, BorderLayout.WEST);
		gameField.setVisible(true);

	}
}

class GamePanel extends JPanel {

	public GamePanel() {
		setBorder(BorderFactory.createLineBorder(Color.red));
	}
}