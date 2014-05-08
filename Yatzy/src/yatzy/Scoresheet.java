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

	
	private static final int COLUMNS = 7;
	private static final int ROWS = 19;

	/**
	 * Constructor for Score sheet
	 */
	public Scoresheet() {
		setLayout(new GridLayout());
		JButton test = new JButton("blab");
		add(test);
		drawSheet(COLUMNS, ROWS);
		
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
