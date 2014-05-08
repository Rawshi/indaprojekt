package yatzy;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class Scoresheet - Constructs the score sheet, etc.
 * 
 * @author Kashmir Klingestedt & Edvard Mickos
 * @version 1.0
 */
public class Scoresheet extends JPanel {

	int players;
	private int columns;
	private static final int ROWS = 19;
	public String[] rules = new String[19]; {
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
	public Scoresheet(int players) {
		columns=players+1;
		setLayout(new GridLayout(ROWS, columns));
		for (int i=0; i<ROWS; i++){
		JButton test = new JButton(rules[i]);
		add(test);
		}
		this.players = players;
		
	}

	/**
	 * Draws the score sheet
	 * 
	 * @param columns Amount of columns
	 * @param rows Amount of rows
	 */
	public void drawSheet(int columns, int rows) {

	}

	/**
	 * Checks the values of the dices to figure out where it is allowed to put the score.
	 */
	public void clickScore() {

	}
}
