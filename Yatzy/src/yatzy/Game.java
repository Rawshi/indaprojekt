package yatzy;

import java.awt.Color;
import java.awt.Dimension;
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
		gameBackround.add(new JButton("Tryck på mig ples"));
		gameField.setVisible(true);

	}
}

class GamePanel extends JPanel {

	public GamePanel() {
		setBorder(BorderFactory.createLineBorder(Color.red));
	}
}