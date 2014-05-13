package yatzy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class Scoresheet - Constructs the score sheet, etc.
 * 
 * @author Kashmir Klingestedt & Edvard Mickos
 * @version 1.0
 */
public class Scoresheet extends JPanel {

	private int playerAmount;
	private int columns;
	private int turnCount;
	private static final int ROWS = 19;
	private int currentPlayer = 1;
	private JButton[] scoreButtons = new JButton[ROWS];
	private ScoreSquare[][] results;
	private GamePanel gameBackground;
	private String[] rules = new String[] {
			"", // 0,0 empty square
			"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Sum",
			"Bonus", "1 pair", "2 pair", "3 of a kind", "4 of a kind",
			"Small Straight", "Large Straight", "Full House", "Chance",
			"Yatzy", "Total", };

	/**
	 * Constructor for Score sheet
	 */
	public Scoresheet(int players, GamePanel panel) {
		turnCount = 0;
		gameBackground = panel;
		playerAmount = players - 1;
		results = new ScoreSquare[players][ROWS];
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
			scoreButtons[i] = button;
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
				ScoreSquare l = new ScoreSquare();
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

		results[1][0].setBackground(Color.yellow); // Creates the square
													// to tell which
													// players turn it
													// is.
	}

	/**
	 * Checks the values of the dices to figure out where it is allowed to put
	 * the score.
	 */
	public void addScore(JButton b, final int row) {
		switch (row) {
		case 1: // ones
			simpleDiceSide(b, row);
			break;
		case 2: // twos
			simpleDiceSide(b, row);
			break;
		case 3: // threes
			simpleDiceSide(b, row);
			break;
		case 4: // fours
			simpleDiceSide(b, row);
			break;
		case 5: // fives
			simpleDiceSide(b, row);
			break;
		case 6: // sixes
			simpleDiceSide(b, row);
			break;
		case 7: // Sum
			b.setEnabled(false);
			break;
		case 8: // Bonus
			b.setEnabled(false);
			break;
		case 9: // One Pair
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((gameBackground.getRollCount() == 0)) {
						return;
					}
					HashSet<Integer> pair = pair();
					if (pair.size() == 2) {
						for (Integer i : pair) {
							int yesNo = JOptionPane.showConfirmDialog(null,
									"Do you want to use the pair of "
											+ (int) (i + 1) + "'s", "Yatzhee",
									JOptionPane.YES_NO_OPTION);
							if (yesNo == 0) {
								setTextAndScore(2 * (i + 1), row);
								return;
							}
						}
					} else if (pair.size() == 1) {
						for (Integer i : pair) {
							setTextAndScore(2 * (i + 1), row);
							return;

						}
					}
					setTextAndScore(0, row);
				}
			});
			break;
		case 10: // Two Pairs
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((gameBackground.getRollCount() == 0)) {
						return;
					}
					HashSet<Integer> pair = pair();
					int add = 0;
					if (pair.size() < 2) {
						setTextAndScore(0, row);
						return;
					}
					for (int i : pair) {
						add += i + 1;
					}
					setTextAndScore(2 * add, row);
				}
			});
			break;
		case 11: // Three of a kind
			checkOfAKind(b, row, 3, false);

			break;
		case 12: // Four of a kind
			checkOfAKind(b, row, 4, false);

			break;
		case 13: // Small Straight
			checkStraight(b, row, 15, 1, 5);

			break;
		case 14: // Large Straight
			checkStraight(b, row, 20, 2, 6);

			break;
		case 15: // Full House
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int[] diceSide = gameBackground.getDiceSides();
					HashSet<Integer> dice = new HashSet<Integer>();
					for (int i = 0; i < 5; i++) {
						dice.add(diceSide[i]);
					}
					if (dice.size() == 2) {
						int sum = 0;
						for (int i = 0; i < 5; i++) {
							sum += (diceSide[i] + 1);
						}
						setTextAndScore(sum, row);
						return;
					}
					setTextAndScore(0, row);

				}
			});
			break;
		case 16: // Chance
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int[] diceSide = gameBackground.getDiceSides();
					int sum = 0;
					for (int i = 0; i < diceSide.length; i++) {
						sum += (diceSide[i] + 1);
					}
					setTextAndScore(sum, row);
				}
			});
			break;
		case 17: // Yatzy
			checkOfAKind(b, row, 5, true);
			break;
		case 18:
			b.setEnabled(false);
			break;
		}
	}

	/**
	 * Checks wether the current dice has a @param whatKind-of a kind and writes
	 * it if it is to the scoresheet and gives the option to zero it out if it
	 * isn't
	 * 
	 * @param row
	 * @param whatKind
	 *            if it is three four or yatzy
	 * @param isYatzy
	 *            if it is a yatzy-check to give proper score.
	 */
	private void checkOfAKind(JButton b, final int row, final int whatKind,
			final boolean isYatzy) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] diceSide = gameBackground.getDiceSides();
				for (int i = 0; i < 5; i++) {
					int diceCount = 0;
					for (int j = 4; i < j; j--) {
						if (diceSide[i] == diceSide[j]) {
							diceCount++;
						}
						if (diceCount >= whatKind - 1) {
							if (isYatzy) {
								setTextAndScore(50, row);
								return;
							}
							setTextAndScore(whatKind * (diceSide[j] + 1), row);
							return;
						}
					}
				}
				setTextAndScore(0, row);
			}
		});
	}

	private void checkStraight(JButton b, final int row, int score,
			final int from, final int to) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Set<Integer> straight = new HashSet<>();
				for (int i = from; i < to; i++) { // making a default example of
													// one of
													// the possible straights
					straight.add(i);
				}
				int[] diceSide = gameBackground.getDiceSides();
				HashSet<Integer> dice = new HashSet<Integer>();
				for (int i = 0; i < 5; i++) {
					dice.add(diceSide[i]);
				}
				if (dice.containsAll(straight)) {
					setTextAndScore(30, row);
					return;
				}
				setTextAndScore(0, row);
			}
		});
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
			turnCount++;
			if (turnCount > 14) {
				gameEnds();
			}
			currentPlayer = 1;
			gameBackground.resetRoll();
		} else {
			currentPlayer++;
			gameBackground.resetRoll();
		}
		results[currentPlayer][0].setBackground(Color.yellow);
		for (int i = 1; i < results[currentPlayer].length; i++) {
			if (i == 7 || i == 8 || i == 18) { // Sum Bonus and Total should
												// always be locked.
				scoreButtons[i].setEnabled(false);
				continue;
			}
			scoreButtons[i].setEnabled(!results[currentPlayer][i].hasScore());

		}

	}

	/**
	 * Sets the number @param add in the spot of the current player and
	 * dice-choice
	 * 
	 * @param currentPlayer
	 * @param add
	 * @param diceChoice
	 */
	private boolean setTextAndScore(int add, int diceChoice) {
		if (add == 0) {
			int yesNo = JOptionPane.showConfirmDialog(this,
					"Do you want to set this options result to zero?", "Yatzy",
					JOptionPane.YES_NO_OPTION);
			if (yesNo == 1 || yesNo == -1) {
				return false;
			}
		}
		results[currentPlayer][diceChoice]
				.setHorizontalAlignment(SwingConstants.CENTER);
		results[currentPlayer][diceChoice]
				.setVerticalAlignment(SwingConstants.CENTER);
		if (add == 0) {
			results[currentPlayer][diceChoice].setText("-");
			results[currentPlayer][diceChoice].setScore(0);
		} else {
			results[currentPlayer][diceChoice].setText(Integer.toString(add));
			results[currentPlayer][diceChoice].setScore(add);
		}
		setTotal();
		setSum();
		nextPlayer();
		return true;

	}

	/**
	 * for Passive effect of gameplay (like sum calculation)
	 */
	private void setTextNoGamePlay(int add, int diceChoice) {
		results[currentPlayer][diceChoice]
				.setHorizontalAlignment(SwingConstants.CENTER);
		results[currentPlayer][diceChoice]
				.setVerticalAlignment(SwingConstants.CENTER);
		if (add == 0) {
			results[currentPlayer][diceChoice].setText("-");
			results[currentPlayer][diceChoice].setScore(0);
		} else {
			results[currentPlayer][diceChoice].setText(Integer.toString(add));
			results[currentPlayer][diceChoice].setScore(add);
		}
	}

	/**
	 * The action of a button asking for a simple dice result
	 * 
	 * @param b
	 * @param row
	 */
	private void simpleDiceSide(JButton b, final int row) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((gameBackground.getRollCount() == 0)) {
					return;
				}
				int add = checkDice(row);
				if (!setTextAndScore(add, row)) {
					return;
				}
			}
		});
	}

	private void setSum() {
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			sum += results[currentPlayer][i].getScore();
		}
		if (sum > 63) {
			setTextNoGamePlay(50, 8);
		}
		setTextNoGamePlay(sum, 7);
	}

	private void setTotal() {
		int total = 0;
		for (int i = 1; i <= 6; i++) {
			total += results[currentPlayer][i].getScore();
		}
		for (int i = 8; i < results[currentPlayer].length - 1; i++) {
			total += results[currentPlayer][i].getScore();
		}
		setTextNoGamePlay(total, 18);
	}

	private HashSet<Integer> pair() {
		HashSet<Integer> pair = new HashSet<Integer>();
		int[] diceSide = gameBackground.getDiceSides();
		for (int i = 0; i < 5; i++) {
			for (int j = 4; i < j; j--) {
				if (diceSide[i] == diceSide[j]) {
					pair.add(diceSide[i]);
				}
			}
		}
		return pair;
	}

	public void gameEnds() {
		int winner = -1;
		int largest = 0;
		for (int i = 1; i < playerAmount + 2; i++) {
			if (results[i][18].getScore() > largest) {
				largest = results[i][18].getScore();
				winner = i;
			}
		}
		JOptionPane.showMessageDialog(null, "Congratulations player " + winner
				+ " for winning with a score of " + largest);
		System.exit(0);

	}
}
