package yatzy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class Scoresheet - Constructs the score sheet, etc.
 * 
 * @author Kashmir Klingestedt & Edvard Mickos
 * @version 1.0
 */
public class Scoresheet extends JPanel {

	int playerAmount;
	private int columns;
	private static final int ROWS = 19;
	private int currentPlayer = 1;
	JLabel[][] results;
	GamePanel gameBackground;
	public String[] rules = new String[] {
			"", // 0,0 empty square
			"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Sum",
			"Bonus", "1 pair", "2 pair", "3 of a kind", "4 of a kind",
			"Small Straight", "Large Straight", "Full House", "Chance",
			"Yatzy", "Total", };

	/**
	 * Constructor for Score sheet
	 */
	public Scoresheet(int players, GamePanel panel) {
		gameBackground = panel;
		playerAmount = players - 1;
		results = new JLabel[players][ROWS];
		setLayout(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		setupRuleButtons(grid);
		setupLabels(grid);
	}

	public void setupRuleButtons(GridBagConstraints grid) {
		for (int i = 1; i < ROWS; i++) { // starts from 1 to skip the empty 0,0
			JButton button = new JButton(rules[i]);
			addScore(button, i);
			grid.fill = GridBagConstraints.HORIZONTAL;
			grid.gridx = 0;
			grid.gridy = i;
			add(button, grid);
		}

	}

	/**
	 * Creates a 17 * amount of players matrix of labels to save and
	 * 
	 * @param grid
	 */
	public void setupLabels(GridBagConstraints grid) {
		for (int i = 1; i < results.length; i++) { // starts from 1 to skip 0,0
			for (int j = 0; j < results[0].length; j++) {
				JLabel l = new JLabel();
				l.setMinimumSize(new Dimension(20, 5));
				l.setPreferredSize(new Dimension(20, 5));
				grid.fill = GridBagConstraints.HORIZONTAL;
				l.setOpaque(true);
				l.setBackground(Color.white);
				grid.insets = new Insets(0, 10, 10, 0);
				grid.gridx = i;
				grid.gridy = j;
				grid.ipadx = 20;
				grid.ipady = 10;
				results[i][j] = l;
				add(l, grid);
				results[1][0].setBackground(Color.yellow); // Creates the square
															// to tell which
															// players turn it
															// is.
			}
		}
	}

	/**
	 * Checks the values of the dices to figure out where it is allowed to put
	 * the score.
	 */
	public void addScore(JButton b, final int row) {
		switch (row) {
		case 1:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(1);
					setText(currentPlayer, add, 1);
					nextPlayer();
				}
			});
			break;
		case 2:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(2);
					setText(currentPlayer, add, 2);
					nextPlayer();
				}
			});
			break;
		case 3:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(3);
					setText(currentPlayer, add, 3);
					nextPlayer();
				}
			});
			break;
		case 4:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(4);
					setText(currentPlayer, add, 4);
					nextPlayer();
				}
			});
			break;
		case 5:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(5);
					setText(currentPlayer, add, 5);
					nextPlayer();
				}
			});
			break;
		case 6:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(6);
					setText(currentPlayer, add, 6);
					nextPlayer();
				}
			});
			break;
		case 7:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 8:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 9:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 10:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 11:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 12:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 13:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 14:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 15:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 16:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 17:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		case 18:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			break;
		}
	}

	/**
	 * Checks for single digit dice amount
	 * 
	 * @param diceWant
	 *            the requested side up number on the dice
	 * @return the total sum of all dice with that side up
	 */
	private int checkDice(int diceWant) {
		int sum = 0;
		int[] dices = gameBackground.getDiceSides();
		for (int i = 0; i < dices.length; i++) {
			int sideUp = (dices[i] + 1);
			if (sideUp == diceWant) {
				sum += sideUp;
			}
		}
		return sum;
	}
	
	

	/**
	 * Checks if the current player is the laste one and resets if that is the
	 * case.
	 */
	private void nextPlayer() {
		results[currentPlayer][0].setBackground(Color.white);
		if (currentPlayer == playerAmount) {
			currentPlayer = 1;
			gameBackground.resetRoll();
		} else {
			currentPlayer++;
			gameBackground.resetRoll();
		}
		results[currentPlayer][0].setBackground(Color.yellow);

	}

	/**
	 * Sets the number @param add in the spot of the current player and dice-choice 
	 * @param currentPlayer
	 * @param add
	 * @param diceChoice
	 */
	private void setText(int currentPlayer, int add, int diceChoice) {
		results[currentPlayer][diceChoice]
				.setHorizontalAlignment(SwingConstants.CENTER);
		results[currentPlayer][diceChoice]
				.setVerticalAlignment(SwingConstants.CENTER);
		if(add==0){
			results[currentPlayer][diceChoice].setText("-");
		}
		else{
		results[currentPlayer][diceChoice].setText(Integer.toString(add));
		}
	}
}
