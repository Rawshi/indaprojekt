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
	Dice[] dices;
	GamePanel gameBackground;
	public String[] rules = new String[19];
	{
		rules[1] = "Ones";
		rules[2] = "Twos";
		rules[3] = "Threes";
		rules[4] = "Fours";
		rules[5] = "Fives";
		rules[6] = "Sixes";
		rules[7] = "Sum";
		rules[8] = "Bonus";
		rules[9] = "1 pair";
		rules[10] = "2 pair";
		rules[11] = "3 of a kind";
		rules[12] = "4 of a kind";
		rules[13] = "Small Straight";
		rules[14] = "Large Straight";
		rules[15] = "Full House";
		rules[16] = "Chance";
		rules[17] = "Yatzy";
		rules[18] = "Total";
	}

	/**
	 * Constructor for Score sheet
	 */
	public Scoresheet(int players, GamePanel panel) {
		gameBackground = panel;
		playerAmount = players - 1;
		dices = panel.getDice();
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
			for (int j = 1; j < results[0].length; j++) {
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
					results[currentPlayer][1].setText(Integer.toString(add));
					nextPlayer();
				}
			});
			break;
		case 2:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(2);
					results[currentPlayer][2].setText(Integer.toString(add));
					nextPlayer();
				}
			});
			break;
		case 3:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(3);
					results[currentPlayer][3].setText(Integer.toString(add));
					nextPlayer();
				}
			});
			break;
		case 4:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(4);
					results[currentPlayer][4].setText(Integer.toString(add));
					nextPlayer();
				}
			});
			break;
		case 5:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(5);
					results[currentPlayer][5].setText(Integer.toString(add));
					nextPlayer();
				}
			});
			break;
		case 6:
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int add = checkDice(6);
					results[currentPlayer][6].setText(Integer.toString(add));
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
		for (int i = 0; i < dices.length; i++) {
			int sideUp = (dices[i].getSideUp() + 1);
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
		if (currentPlayer == playerAmount) {
			currentPlayer = 1;
			return;
		}
		currentPlayer++;
		gameBackground.resetRoll();

	}
}
