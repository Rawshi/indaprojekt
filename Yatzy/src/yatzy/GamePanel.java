package yatzy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A Backround panel where the dices are placed
 * 
 * @author Edvard Mickos & Kashmir Klingestedt
 * 
 */
public class GamePanel extends JPanel {

	private JButton rollButton;
	private Dice[] dices;
	private int rollCount;

	/**
	 * Constructor for GamePanel.
	 * Adds five dices and a roll button to the game panel.
	 */
	public GamePanel() {
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(200, 600));
		rollButton = new JButton("Roll");
		GridBagConstraints c = new GridBagConstraints();
		dices = new Dice[5];
		rollCount = 0;

		// adds the dices to the panel
		for (int i = 0; i < 5; i++) {
			dices[i] = new Dice();
			c.gridx = 0;
			c.gridy = i;
			add(dices[i].addDice(), c);
		}

		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rollCount == 0) {
					for (Dice dice : dices) {
						if (dice.rollCheck()) {
							JOptionPane.showMessageDialog(null, "You can't roll while previous dice are locked");
							return;
						}
					}
				}
				if (rollCount == 2) {
					rollAllDice();
					rollCount++;
					rollButton.setEnabled(false);
				} else {
					rollAllDice();
				}
				rollCount++;
			}
		});
		
		// adds the roll button to the panel
		c.gridx = 1;
		c.gridy = 2;
		c.ipadx = 40;
		c.ipady = 20;
		add(rollButton, c);
	}

	/**
	 * Resets the dices and roll button.
	 */
	public void resetRoll() {
		rollCount = 0;
		rollButton.setEnabled(true);
		for (int i = 0; i < 5; i++){
			dices[i].unlock();
			dices[i].setVisible(false);
		}
	}

	/**
	 * @return The amount of times the dices has been thrown this turn.
	 */
	public int getRollCount() {
		return rollCount;
	}

	/**
	 * Checks the value of every dice.
	 * @return An int array with the values of the dices.
	 */
	public int[] getDiceSides() {
		return new int[]{
				dices[0].getSideUp(),
				dices[1].getSideUp(),
				dices[2].getSideUp(),
				dices[3].getSideUp(),
				dices[4].getSideUp(),
		};
	}

	/**
	 * Rolls the dices.
	 */
	private void rollAllDice() {
		for (Dice dice : dices) {
			dice.roll();
			dice.setVisible(true);
		}
	}

	/**
	 * Kommer antagligen inte att behövas.
	 */
	// @Override
	// public void paintComponent(Graphics g){
	// super.paintComponent(g);
	//
	// // Image dice1 =
	// Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
	//
	// // g.drawImage(dice1, 150, 10, this);
	//

}