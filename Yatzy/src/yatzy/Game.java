package yatzy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
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
		JFrame gameField = new JFrame("Yatzy");
		Game.GamePanel gameBackround = new Game.GamePanel();
		gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameField.setSize(850,600);
		gameField.add(gameBackround);
		gameField.setVisible(true);

	}
	
	
	static class GamePanel extends JPanel {

		public GamePanel() {
			setBorder(BorderFactory.createLineBorder(Color.red));
			setLayout(new BorderLayout());
			final JPanel startMenu = new JPanel(new GridLayout(4,1));
			
			JButton onePlayer = new JButton("One Player");
			JButton twoPlayer = new JButton("Two Players");
			
			add(startMenu, BorderLayout.WEST);
			startMenu.add(onePlayer, BorderLayout.WEST);
			startMenu.add(twoPlayer, BorderLayout.WEST);
			
			onePlayer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				startMenu.setVisible(false);
				}
			});
		}
	}
}

